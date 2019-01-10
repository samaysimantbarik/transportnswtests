To execute: mvn clean test
To get reports: mvn cluecumber-report:reporting

Execute and get reports : mvn cluecumber-report:reporting

To start zelenium: Run the below from command line

 docker run --rm -ti --name zalenium -p 4444:4444 ^
      -v /var/run/docker.sock:/var/run/docker.sock ^
         --privileged dosel/zalenium start --desiredContainers 20

