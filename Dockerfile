# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Set Env
ENV TZ Asia/Shanghai

# The application's jar file
ARG JAR_FILE=target/trainingService*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} trainingService.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/trainingService.jar"]