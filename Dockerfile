FROM openjdk:17-slim
WORKDIR /app
COPY target/date-bot-1.0.0.jar datebot.jar
CMD ["java", "-jar", "datebot.jar"]
