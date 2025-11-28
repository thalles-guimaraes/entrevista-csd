FROM clojure:temurin-17-lein AS build

WORKDIR /app
COPY . .

RUN lein uberjar

# -------------------------

FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/target/projeto_entrevista-0.1.0-SNAPSHOT-standalone.jar app.jar

ENV PORT=8080
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
