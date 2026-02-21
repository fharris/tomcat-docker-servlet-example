# tomcat-docker-servlet-example
tomcat-docker-servlet-example

The Docker image  includes has a `message.txt` file baked into `/usr/local/tomcat/shared/message.txt`. 
The servlet reads this file and returns its contents. If there is not file, a Hello World message is returned.
A container will be started on port 8083, and `curl http://localhost:8083/` returns "Greetings from inside the Docker image!" 


## To test:

❯ cd tomcat-hello

❯ docker build -t tomcat-hello-image .

❯ docker run -d -p 8083:8080 --name tomcat-hello-container5 tomcat-hello-image

curl -s http://localhost:8083/                                                                                                    

Greetings from inside the Docker image!



