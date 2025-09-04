# Etapa de construcción
FROM maven:3.9.4-eclipse-temurin-17-alpine AS builder

WORKDIR /app

COPY pom.xml ./
COPY .mvn .mvn
COPY mvnw ./
COPY src ./src

# Compila el proyecto y empaqueta sin tests
RUN ./mvnw clean package -DskipTests

# Etapa de runtime minimalista
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Crea carpeta de logs si tu app lo requiere
RUN mkdir -p /app/logs

# Copia solo el JAR final desde el builder
COPY --from=builder /app/target/student-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8082

# Punto de entrada
ENTRYPOINT ["java", "-jar", "app.jar"]
