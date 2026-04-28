FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy only required files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Build project
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Copy built jar
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
