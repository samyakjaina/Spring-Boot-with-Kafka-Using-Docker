FROM maven:3.8.5-openjdk-17

# Set the working directory inside the container
WORKDIR /kafkaDocker

# Copy the Maven project files into the container
COPY pom.xml .
COPY src ./src

# Build the Maven project
RUN mvn clean install -DskipTests

# Expose any necessary ports
EXPOSE 9082

#docker exec -it dockerdemoproject-mysqldb-1  mysql -u root -p to check the db from the command prompt

# Specify the command to run on container startup
CMD ["java", "-jar", "target/kafkaDocker-0.0.1-SNAPSHOT.jar"]