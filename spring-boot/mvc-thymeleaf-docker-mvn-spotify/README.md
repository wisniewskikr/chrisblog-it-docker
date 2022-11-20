SPRING BOOT MVC THYMELEAF AND DOCKER WITH MAVEN SPOTIFY PLUGIN
==============================================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

This is simple Spring Boot MVC project which displays "Hello World" text. 
Main goal of this project is to show how to integrate Spring Boot application with Docker and Maven Spotify Plugin.
Docker`s image is built only by using Maven command.

Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf
* **Other**: Docker


IMPLEMENTATION
--------------

Prerequisitions:
* Downloaded code of application mvc-thymeleaf-docker;
* Installed tool Docker;
* Created an account on hub.docker.com (in my case "wisniewk").

Implementation details:
* In file "pom.xml" was added new profile "docker".

** Additional Notes **
Maven command to build docker image:
** mvn clean install -PdockerImage **

  

LAUNCH
------

To launch project please run following class: 
* Application.java

You can also launch project using Maven command:
* mvn spring-boot:run -Dspring.thymeleaf.cache=false


USAGE
-----

Link to main UI:
* http://[server]/app/greeting

Maven command to build docker image:
** mvn clean install -Ddocker **