#!bin/sh
#
#  Windows users run the script only in power shell
#

#Stopping all containers of our application
echo "Stopping all containers of CoDaemons"
docker-compose -f docker-compose-dev.yml stop

sleep 5

#Cleaning up
echo "Cleaning up!"
rm -rf srv