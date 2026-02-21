# Multi-stage build: first stage builds the WAR using Maven
FROM maven:3.9-eclipse-temurin-8 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Second stage: use Tomcat and deploy the WAR as ROOT
FROM tomcat:9-jdk8-openjdk-slim
# Clean default webapps
RUN rm -rf /usr/local/tomcat/webapps/*
# Copy the built WAR as ROOT.war
COPY --from=builder /app/target/hello.war /usr/local/tomcat/webapps/ROOT.war
# Ensure the shared directory exists and copy the message file
RUN mkdir -p /usr/local/tomcat/shared
COPY message.txt /usr/local/tomcat/shared/message.txt
# Expose Tomcat HTTP port
EXPOSE 8080
