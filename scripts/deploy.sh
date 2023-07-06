#!/bin/bash
HOST_NAME=$(cat /etc/hostname)
BUILD_PATH=$(ls /home/ubuntu/app/lionheart-api.jar)
JAR_NAME=$(basename $BUILD_PATH)
echo "> build 파일명: $JAR_NAME"

echo "> build 파일 복사"
DEPLOY_PATH=/home/ubuntu/app/nonstop/jar/
cp $BUILD_PATH $DEPLOY_PATH

echo "> 현재 구동중인 PORT 확인"
CURRENT_PORT=$(cat /etc/nginx/conf.d/service-url.inc | grep -Po '[0-9]+' | tail -1)
echo "> $CURRENT_PORT"

# 쉬고 있는 port 찾기: 8081이 사용중이면 8082가 쉬고 있고, 반대면 8081이 쉬고 있음
if [ $CURRENT_PORT == 8081 ]
then
  IDLE_PORT=8082
elif [ $CURRENT_PORT == 8082 ]
then
  IDLE_PORT=8081
else
  echo "> 일치하는 PORT가 없습니다. PORT: $CURRENT_PORT"
  echo "> 8081 포트를을 할당합니다. IDLE_PORT: 8081"
  IDLE_PORT=8081
fi

echo "> application.jar 교체"
IDLE_APPLICATION=$IDLE_PORT-$JAR_NAME # 8081-lionheart-api.jar
IDLE_APPLICATION_PATH=$DEPLOY_PATH$IDLE_APPLICATION

ln -Tfs $DEPLOY_PATH$JAR_NAME $IDLE_APPLICATION_PATH

echo "> $HOST_NAME 에서 구동중인 애플리케이션 pid 확인"
IDLE_PID=$(pgrep -f $IDLE_APPLICATION)

if [ -z $IDLE_PID ]
then
  echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "> kill -15 $IDLE_PID"
  kill -15 $IDLE_PID
  sleep 5
fi

echo "> 배포"
if [ ${HOST_NAME} == "blossom-prod-server" ]; then
  nohup java -jar -Duser.timezone=Asia/Seoul -Dserver.port=$IDLE_PORT -Dspring.profiles.active=prod $IDLE_APPLICATION_PATH >> /home/ubuntu/app/nohup.out 2>&1 &
  exit 0
else
  nohup java -jar -Duser.timezone=Asia/Seoul -Dserver.port=$IDLE_PORT -Dspring.profiles.active=dev $IDLE_APPLICATION_PATH >> /home/ubuntu/app/nohup.out 2>&1 &
  exit 0


echo "> $HOST_NAME 10초 후 Health check 시작"
sleep 10

for retry_count in {1..10}
do
  response=$(curl -s http://localhost:$IDLE_PORT/actuator/health)
  up_count=$(echo $response | grep 'UP' | wc -l)

  if [ $up_count -ge 1 ]
  then # $up_count >= 1 ("UP" 문자열이 있는지 검증)
      echo "> Health check 성공"
      break
  else
      echo "> Health check의 응답을 알 수 없거나 혹은 status가 UP이 아닙니다."
      echo "> Health check: ${response}"
  fi

  if [ $retry_count -eq 10 ]
  then
    echo "> Health check 실패. "
    echo "> Nginx에 연결하지 않고 배포를 종료합니다."
    exit 1
  fi

  echo "> Health check 연결 실패. 재시도..."
  sleep 10
done

echo "> 스위칭"
sleep 10