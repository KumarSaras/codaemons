#!bin/sh
#
#  Windows users run the script only in power shell
#

#Cleaning up contnainers
echo "Cleaning up contnainers"
docker-compose -f docker-compose-dev.yml stop

sleep 5

#Cleaning up temp files
echo "Cleaning up temp files!"
rm -rf srv