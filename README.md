# Accessing the MySQL Database with Spring Boot

This is a Spring Boot application linked to a MySQL database image in Docker container. It was developed for data manipulation in a relational database and documented in a Systems Analysis and Development course article.

**What was used in the project:** 
- Spring Initializr <https://start.spring.io/>
- Spring Boot 2.1.11
- JDK 1.8 or later
- Maven
- Docker
- MySQL
- Valentina Studio
- Postman

**Useful commands:**
- docker run -p3306:3306 mysql
- docker run -p3306:3306 -eMYSQL_ROOT_PASSWORD=1903 mysql
- docker-compose up -d
- ./mvnw spring-boot:run

