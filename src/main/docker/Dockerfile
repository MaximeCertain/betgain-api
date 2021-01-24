FROM maven:3.6.3-openjdk-11
EXPOSE 8080
COPY . .
RUN mvn clean package -DskipTests
COPY src/main/docker/commands_app.sh /scripts/commands_app.sh
RUN ["chmod", "+x", "/scripts/commands_app.sh"]
ENTRYPOINT ["/scripts/commands_app.sh"]


#FROM adoptopenjdk:11-jre-hotspot
#EXPOSE 8080
#ARG JAR_FILE=*.jar
#COPY ${JAR_FILE} application.jar
#ENTRYPOINT ["java", "-jar", "application.jar"]