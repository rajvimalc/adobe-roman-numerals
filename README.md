
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

### For Executable Jar:

_Gradle Wrapper build command (Windows):_ 
    
    .\gradlew clean build
    

Creates `adobe-roman-numerals-{version}.jar` file at `\build\libs` which can be run as executable jar.

_Run the executable jar as (Windows):_
    
    java -jar -Dspring.profiles.active=prod .\build\libs\adobe-roman-numerals-1.0.0.jar


### For Docker:

    .\gradlew clean build

    docker build -t adobe-roman-numerals .

    docker-compose up

    docker-compose down

_To access Kibana Dashboard:_
    
    http://localhost:5601
    
    Discover => Create Index pattern => Step 1: logstash-* => Step 2: @timestamp => Discover


### APIs:

Numeral to Roman (Integer range: 1 - 3999): `http://localhost:8080/romannumeral?query={integer}`

Health Check: `http://localhost:8080/`

Host Info: `http://localhost:8080/romannumeral/api/v1/host-info`

Actuator: `http://localhost:8080/romannumeral/actuator`
