#!bin/sh
#
#  Windows users run the script only in power shell
#

#Cleaning up contnainers and volumes
echo "Cleaning up contnainers and volumes"
docker-compose -f docker-compose-setup.yml down -v

sleep 5

#Cleaning up temp files
echo "Cleaning up temp files!"
rm -rf srv