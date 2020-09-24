# AOP

This repository contains a simple code to demonstrate AOP

This project focuses only on the AOP functionality with simple use cases

## Build

Build with the included Maven wrapper

    ./mvnw clean install

## Usage

Run via command line

    ./mvnw spring-boot:run

## Endpoints

[Regular Logging](./src/main/java/com/mp/aop/aspect/LoggingAspect.java)

    http://localhost:8081/passenger/{any-string}
 
[Custom Annotation](./src/main/java/com/mp/aop/aspect/custom)
    
    http://localhost:8081/passenger
    
[Exception Aspect](./src/main/java/com/mp/aop/aspect/ExceptionAspect.java)
    
    http://localhost:8081/passenger/john-doe