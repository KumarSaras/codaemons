#!bin/sh
#
#  Windows users run the script only in power shell
#
#Building the spring-boot application. You can comment if you are manually building it.
cd codaemons-be
./mvnw clean install
cd ..

#Removing all stopped containers. This is done to avoid conflicts with already existing db containers.
echo "Deleting containers!"
cntrs=$(docker container ls -a -q)
docker rm ${cntrs}

#Run the db and redis containers for judge0
echo "Starting all containers!"
docker-compose -f docker-compose-dev.yml up -d db redis

#Sleep 10s
sleep 10

#Run other containers
docker-compose -f docker-compose-dev.yml up --build -d

#Sleep 3s. Wait for everuthing to start
sleep 10