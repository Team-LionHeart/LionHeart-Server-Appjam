NOW_TIME="$(date +%Y)-$(date +%m)-$(date +%d) $(date +%H):$(date +%M):$(date +%S)"

HOST_NAME=$(cat /etc/hostname)
TARGET_PORT=8083

TARGET_PID=$(lsof -Fp -i TCP:${TARGET_PORT} | grep -Po 'p[0-9]+' | grep -Po '[0-9]+')

if [ ! -z ${TARGET_PID} ]; then
  echo "[$NOW_TIME] Kill WAS running at ${TARGET_PORT}." >> /home/ubuntu/notification-server/deploy.log
  sudo kill -15 ${TARGET_PID}
fi

if [ ${HOST_NAME} == "lionheart-prod-server" ]; then
  nohup java -jar -Dserver.port=${TARGET_PORT} -Duser.timezone=Asia/Seoul -Dspring.profiles.active=prod /home/ubuntu/notification-server/*.jar >> /home/ubuntu/notification-server/deploy.log 2>/home/ubuntu/notification-server/deploy_err.log &
  echo "[$NOW_TIME] Now new WAS runs at ${TARGET_PORT}." >> /home/ubuntu/notification-server/deploy.log
  exit 0
else
  nohup java -jar -Dserver.port=${TARGET_PORT} -Duser.timezone=Asia/Seoul -Dspring.profiles.active=dev /home/ubuntu/notification-server/*.jar >> /home/ubuntu/notification-server/deploy.log 2>/home/ubuntu/notification-server/deploy_err.log &
  echo "[$NOW_TIME] Now new WAS runs at ${TARGET_PORT}." >> /home/ubuntu/notification-server/deploy.log
  exit 0
fi