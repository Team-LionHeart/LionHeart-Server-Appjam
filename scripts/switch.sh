#!/bin/bash
echo "> 현재 구동중인 Port 확인"
CURRENT_PORT=$(cat /etc/nginx/conf.d/service-url.inc | grep -Po '[0-9]+' | tail -1)

# 쉬고 있는 port 찾기: 8081이 사용중이면 8082가 쉬고 있고, 반대면 8081이 쉬고 있음
if [ $CURRENT_PORT -eq 8081 ]
then
  IDLE_PORT=8082
elif [ $CURRENT_PORT == 8082 ]
then
  IDLE_PORT=8081
else
  echo "> 일치하는 PORT가 없습니다."
  echo "> 8081을 할당합니다."
  IDLE_PORT=8081
fi

echo "> 전환할 Port: $IDLE_PORT"
echo "> Port 전환"
echo "set \$service_url http://127.0.0.1:${IDLE_PORT};" |sudo tee /etc/nginx/conf.d/service-url.inc

echo "> Nginx Current Proxy Port: $IDLE_PORT"

echo "> Nginx Reload"
sudo service nginx reload