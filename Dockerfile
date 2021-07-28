#FROM openjdk:11-jdk-slim
FROM adoptopenjdk/openjdk11:alpine-slim

MAINTAINER srncristea@gmail.com

#
# define a new user to run the app, avoid in this way ROOT user.
#
# RUN addgroup -S hw && adduser -S hw -G spring
# USER hw:spring

ARG JAR_FILE=target/*.jar
ARG PORT=8080
ARG DEBUG_PORT=5005
WORKDIR /opt/deployments
ENV CONFIG_PROFILE container
ENV CONFIG_LOCATION /opt/deployments/application-${CONFIG_PROFILE}.yml
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=${DEBUG_PORT}"
EXPOSE $PORT
EXPOSE $DEBUG_PORT
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -noverify -XX:+AlwaysPreTouch -Duser.timezone=UTC -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=${CONFIG_PROFILE} -jar app.jar"]
