
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

**For Executable Jar:**

_Gradle Wrapper build command (Windows):_ 
    
    .\gradlew clean build
    

Creates `adobe-roman-numerals-{version}.jar` file at `\build\libs` which can be run as executable jar.

_Run the executable jar as (Windows):_
    
    java -jar -Dspring.profiles.active=prod .\build\libs\adobe-roman-numerals-1.0.0.jar
