NOW_TIME="$(date +%Y)-$(date +%m)-$(date +%d) $(date +%H):$(date +%M):$(date +%S)"

HOST_NAME=$(cat /etc/hostname)
CURRENT_PORT=$(cat /etc/nginx/conf.d/service-url.inc | grep -Po '[0-9]+' | tail -1)
TARGET_PORT=0

echo "[$NOW_TIME] Current port of running WAS is ${CURRENT_PORT}." >> /home/ubuntu/api-server/deploy.log

if [ ${CURRENT_PORT} -eq 8081 ]; then
  TARGET_PORT=8082
elif [ ${CURRENT_PORT} -eq 8082 ]; then
  TARGET_PORT=8081
else
  echo "[$NOW_TIME] No WAS is connected to nginx" >> /home/ubuntu/api-server/deploy.log
fi

TARGET_PID=$(lsof -Fp -i TCP:${TARGET_PORT} | grep -Po 'p[0-9]+' | grep -Po '[0-9]+')

if [ ! -z ${TARGET_PID} ]; then
  echo "[$NOW_TIME] Kill WAS running at ${TARGET_PORT}." >> /home/ubuntu/api-server/deploy.log
  sudo kill ${TARGET_PID}
fi

if [ ${HOST_NAME} == "lionheart-prod-server" ]; then
  nohup java -jar -Dserver.port=${TARGET_PORT} -Dspring.profiles.active=prod /home/ubuntu/api-server/*.jar >> /home/ubuntu/api-server/deploy.log 2>/home/ubuntu/api-server/deploy_err.log &
  echo "[$NOW_TIME] Now new WAS runs at ${TARGET_PORT}." >> /home/ubuntu/api-server/deploy.log
  exit 0
else
  nohup java -jar -Dserver.port=${TARGET_PORT} -Dspring.profiles.active=dev /home/ubuntu/api-server/*.jar >> /home/ubuntu/api-server/deploy.log 2>/home/ubuntu/api-server/deploy_err.log &
  echo "[$NOW_TIME] Now new WAS runs at ${TARGET_PORT}." >> /home/ubuntu/api-server/deploy.log
  exit 0
fi
