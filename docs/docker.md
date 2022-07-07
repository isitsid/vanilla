# Introduction (WIP)

To run tests in docker container below steps could be used \
Step 1/5 : FROM *"url of base image here"*

Step 2/5 : bash commands to install dependencies 

Step 3/5 : COPY *"config files, solution files"* /tmp/

Step 4/5 : COPY docker-entrypoint.sh /

Step 5/5 : ENTRYPOINT ["sh", "/docker-entrypoint.sh"]

Step 6/5 : CMD [ "sleep", "infinity" ]

/docker-entrypoint.sh --> Content would be to have java command which runs the test as we run in command line.


[Click here to go back to readme file](../README.md)
