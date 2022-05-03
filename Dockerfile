FROM openjdk:17
COPY backend/build/libs/*.jar /usr/everyday/everyday.jar
WORKDIR /usr/everyday
CMD ["java","-jar","everyday.jar"]
