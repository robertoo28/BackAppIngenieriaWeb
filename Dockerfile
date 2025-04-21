# Etapa de compilación
FROM maven:3.8-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Crear usuario no privilegiado
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copiar el JAR desde la etapa de compilación
COPY --from=build /app/target/*.jar app.jar

# Configurar variables de entorno
ENV SERVER_PORT=8081
ENV JAVA_OPTS=""

EXPOSE ${SERVER_PORT}
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]