# VehiclePositions

Installation

   1)  downlaod source code from https://github.com/WreathCrystal/VehiclePositions.git
   2)  mvn clean install
   3)  java -jar bmw_test-0.0.1-SNAPSHOT.jar

Uploading data

        url -X POST -H 'secret_key: bmw' -F "file=@//home/lucy/tools/data.csv" -i http://192.168.1.101:8080/vehicle/fileUpload
        change 192.168.1.101 to your server IP.
   

