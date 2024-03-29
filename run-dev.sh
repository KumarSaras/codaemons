#!bin/sh
#
#  Windows users run the script only in power shell
#

#Check if java build is required or not
echo "Do you want to build Spring boot application? [y/n] (Note: If you select 'n' ensure that a jar file with name codaemons-be-0.0.1-SNAPSHOT.jar exists in target folder.)"
read userResponse

if [ $userResponse == 'y' ]
then
	#Building the spring-boot application. You can comment if you are manually building it.
	cd codaemons-be
	./mvnw clean install
	cd ..
fi

#Stop and remove db container
echo "Stopping and removing DB container to handle mount point issue."
docker stop codaemons_cddb_1
docker rm codaemons_cddb_1

#Run the db and redis containers for judge0
echo "Starting all containers!"
docker-compose -f docker-compose-dev.yml up -d db redis

#Sleep 10s
sleep 10

#Run other containers
docker-compose -f docker-compose-dev.yml up --build -d

#Restarting nginx
echo "Restarting Nginx"
docker restart codaemons_nginx_1

#Sleep 3s. Wait for everuthing to start
sleep 10