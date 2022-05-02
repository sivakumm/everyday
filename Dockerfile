FROM openjdk:17
COPY backend/build/libs/backend-0.0.1-SNAPSHOT.jar /usr/everyday/everyday.jar
WORKDIR /usr/everyday
CMD ["java","-jar","everyday.jar"]
