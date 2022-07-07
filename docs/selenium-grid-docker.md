# Run selenium UI tests in Docker containers (WIP)


Step 1: 
#####Spinning up container to run tests
```
 docker run  -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome:latest
```
Step 2:
#####Switching to RemoteWebDriver
Use RemoteWebDriver to specify the IP address and port number for the container.\
Something like 
```

RemoteUrl = localhost:4444/wd/hub
var driver = new Remotewebdriver(new Uri(<RemoteUrl>), options);

```


[Click here to go back to readme file](../README.md)
