
FROM openjdk:11-jdk-oracle
LABEL maintainer="rajvimalc@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 5000 available to the world outside this container
EXPOSE 8080

# The application’s jar file
ARG JAR_FILE=/build/libs/adobe-roman-numerals-*.jar

# Add the application’s jar to the container
ADD ${JAR_FILE} adobe-roman-numerals.jar

# Run the jar file
ENTRYPOINT ["java", "-Xdebug", "-jar", "-Dspring.profiles.active=docker", "adobe-roman-numerals.jar"]
