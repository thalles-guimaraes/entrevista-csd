FROM clojure:temurin-17-lein AS build

WORKDIR /app
COPY . .

# gera o uberjar
RUN lein uberjar

# -------------------------

FROM eclipse-temurin:17-jre

WORKDIR /app

# copia o uberjar gerado
COPY --from=build /app/target/uberjar/projeto_entrevista-0.1.0-SNAPSHOT-standalone.jar app.jar

# o Fly.io injeta PORT automaticamente
ENV PORT=8080

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
