#!bin/sh
#
#  Windows users run the script only in power shell
#
#Building the spring-boot application. You can comment if you are manually building it.
cd codaemons-be
./mvnw clean install
cd ..

#Cleaning up if containers and volumes already exist.
echo "Cleaning up if containers and volumes already exist."
docker-compose -f docker-compose-setup.yml down -v

#Run the db and redis containers for judge0
echo "Starting all containers!"
docker-compose -f docker-compose-setup.yml up -d db redis

#Sleep 10s
sleep 10

#Run other containers
docker-compose -f docker-compose-setup.yml up --build -d

#Sleep 15s. Wait for everything to start
sleep 15