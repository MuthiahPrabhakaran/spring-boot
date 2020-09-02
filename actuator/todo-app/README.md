# todo-app

This repository contains a simple todo application built with Spring Boot

## Build

Build with the included Maven wrapper

    ./mvnw clean install

## Usage

Run via command line

    ./mvnw spring-boot:run

## Endpoints

Custom Health Indicator

    http://localhost:8080/actuator/health
    
Replace health with <i>metrics/beans</i> for respective actuators.

<b>Custom Actuator - Readiness</b>

    http://localhost:8080/actuator/readiness

# Found a bug?

Fork, improve and PR. ;-)



