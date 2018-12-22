FROM openjdk:8-jre-alpine
EXPOSE 8080
COPY ./build/libs/NewsAPI.jar.jar NewsAPI.jar
ENTRYPOINT ["sh", "-c", "java -jar NewsAPI.jar"]
