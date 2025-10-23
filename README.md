```markdown
# simple-java (Spring Boot)

Minimal Spring Boot example exposing an addition REST endpoint and file-based logging.

Build
- mvn -v (ensure Maven is installed)
- mvn package

Run
- With Maven:
  - mvn spring-boot:run
- Or build and run the jar:
  - mvn package
  - java -jar target/simple-java-0.1.0.jar

Endpoints
- GET /add?a=3&b=5
  - Example: curl "http://localhost:8080/add?a=4&b=6"
  - Response (JSON): {"a":4,"b":6,"sum":10}
- POST /add (application/json)
  - Body: {"a":4,"b":6}
  - Response (JSON): {"a":4,"b":6,"sum":10}

Logging
- Application logs are written to logs/application.log by default. Override with:
  - java -Dlogging.file.path=/path/to/log/dir -jar target/simple-java-0.1.0.jar
- Rolling policy: daily files with size-based indexing, max history 30 days.

Test
- mvn test

Notes
- Java 17 and Maven are used.
- Branch suggestion: feature/spring-boot-add-logging
```