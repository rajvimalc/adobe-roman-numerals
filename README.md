
# adobe-roman-numerals

### Numerals to Roman Conversion Project for Adobe Assessment

#### Created August 2021

#### Roman Numerals Reference: https://www.britannica.com/topic/Roman-numeral

**Java Versions Supported:**
`Java SDK 11`

**Servers Supported:**
`Netty Embedded Server`

**Frameworks:**
`Spring Boot 2.5.+`

**Logging:**
`Slf4J with Logback`

**Build Tool:**
`Gradle Wrapper 7.1.1`

**Others:**
`Project Lombok` Annotation Processor, `Intellij` IDE for development

**Testing:**
`Spring Boot` testing with `JUnit`

**Containerization:**
`Docker` with `Docker Compose`

**Log aggregation:**
`Elasticsearch`, `Logstash`, `Kibana` and `Beats`

**Metrics and Monitoring:**
`Prometheus` and `Grafana`


### Download Project

    git clone https://github.com/rajvimalc/adobe-roman-numerals.git

    cd adobe-roman-numerals


### For Executable Jar:

_Gradle Wrapper build command:_ 

Creates `adobe-roman-numerals-{version}.jar` file at `\build\libs` which can be run as executable jar.

Windows: `.\gradlew clean build`

Linux/Mac: `./gradlew clean build`

_Run the executable jar as:_

Windows: `java -jar -Dspring.profiles.active=prod .\build\libs\adobe-roman-numerals-1.0.0.jar`

Linux/Mac: `java -jar -Dspring.profiles.active=prod ./build/libs/adobe-roman-numerals-1.0.0.jar`


### For Docker (Windows: Docker desktop app should be running):

_To run just the application:_

    .\gradlew clean build

    docker build -t adobe-roman-numerals .

    docker run -p 8080:8080/tcp adobe-roman-numerals

_To start the entire docker stack:_
    
    docker-compose up

_To stop the entire docker stack:_
    
    docker-compose down

_To access Kibana Dashboard:_

http://localhost:5601
    
Discover => Create Index pattern => Step 1: logstash-* => Step 2: @timestamp => Discover

_To access Prometheus and Grafana Dashboards:_

http://localhost:9090

http://localhost:3000   (Credentials: admin / admin)


### APIs:

#### Numeral to Roman (Integer range: 1 - 3999): `http://localhost:8080/romannumeral?query={integer}`

_Example:_ http://localhost:8080/romannumeral?query=478

Health Check: http://localhost:8080/

Host Info: http://localhost:8080/romannumeral/api/v1/host-info

Actuator: http://localhost:8080/romannumeral/actuator
