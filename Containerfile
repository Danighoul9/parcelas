# ---------- Etapa 1: compilación ----------
FROM docker.io/library/eclipse-temurin:25-jdk AS build
WORKDIR /app

# Primero solo lo necesario para descargar dependencias (se cachea si no cambian).
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./
RUN chmod +x gradlew && ./gradlew dependencies --no-daemon

# Ahora el código fuente y generación del .jar
COPY src src
RUN ./gradlew bootJar --no-daemon -x test

# ---------- Etapa 2: ejecución ----------
FROM docker.io/library/eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]