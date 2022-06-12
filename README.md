# calls-management-system

## Hi!
Calls management system is an application that manages connections between BTSs and UEs.

## Project modules

1. [network-simulator](https://github.com/PiotrStoklosa/network-simulator)


2. [calls-management-system](https://github.com/PiotrStoklosa/calls-management-system)


3. statistics-and-results-module



## Table of contents
* [How to set up this app locally](#How-to-set-up-this-app-locally)
* [How to run an app](#How-to-run-an-app)
* [Instruction for users](#Instruction-for-users)
* [Documentation for programmers](#Documentation-for-programmers)

## How to set up this app locally
### Docker
1. Install JDK-17 and Gradle 7.4.2
2. Install Docker. If you are using Windows you can download for instance Docker Desktop application available here: https://docs.docker.com/desktop/windows/install/
3. Change directory to root of project
4. Run ```gradle build```
5. When gradle task is complete, run ```docker build --build-arg JAR_FILE=build/libs/\*.jar -t calls-management-system .```
6. Create network for API communication between network-simulator and calls-management-system by running ```docker network create --subnet=172.18.0.0/16 ns-cms-network```
## How to run an app
1. Run ```docker run --net ns-cms-network --ip 172.18.0.22 -p 8080:8080 calls-management-system```
3. The application is now running and available at the http://localhost:8080

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
