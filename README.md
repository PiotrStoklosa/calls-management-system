# calls-management-system

## Hi!
Calls management system is an application that manages connections between BTSs and UEs. It assigns UEs to BTS using attached algorithm (at now application has two: random and max signal). Application also generates report on time and signal strength.

## Project modules

1. [network-simulator](https://github.com/PiotrStoklosa/network-simulator)

2. [calls-management-system](https://github.com/PiotrStoklosa/calls-management-system)

3. [statistics-and-results-report](https://hackmd.io/@yTKMIFmVQSuLpuxpJ1_ppQ/HJhTCzpF9) <br>
  InfluxDB included in this project.<br>
  Comparisons between two different implemetations of algorithm and conclusions (at now only in polish language).<br>



## Table of contents
* [How to set up this app locally](#How-to-set-up-and-run-this-app-locally)
* [Instruction for users](#Instruction-for-users)
* [Documentation for programmers](#Documentation-for-programmers)

## How to set up and run this app locally
1. Install JDK-17 and Gradle 7.4.2 
2. Install influxdb and run this database on port 8086.
3. Generate token and paste it into properties file.
4. Run ```gradle build```
5. Run calls-management-system.

## Instruction for users

## Documentation for programmers

**Technologies:**
- Java 17
- Spring Framework
- Spring Boot
- Gradle
- Log4j2
- JUnit5
- Mockito
- influxDB
