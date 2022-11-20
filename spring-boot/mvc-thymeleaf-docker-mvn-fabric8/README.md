SPRING BOOT MVC THYMELEAF AND DOCKER WITH MAVEN FABRIC8 PLUGIN
==============================================================


LOCALHOST URL
-------------

* **URL**: http://localhost:8080/app/greeting


DESCRIPTION
-----------

This is simple Spring Boot MVC project which displays "Hello World" text. 
Main goal of this project is to show how to integrate Spring Boot application with Docker and Maven Fabric8 Plugin.
Docker`s image is built only by using Maven command.

Used technologies:
* **BE**: Spring Boot MVC
* **FE**: Thymeleaf
* **Other**: Docker


IMPLEMENTATION
--------------

Prerequisites:
* Downloaded code of application mvc-thymeleaf-docker;
* Installed tool Docker;
* Created an account on hub.docker.com (in my case "wisniewk").

Implementation details:
* In file "pom.xml" were added new profiles: "dockerRefreshImage" and "dockerRefreshContainer".

** Additional Notes **
Maven command to build docker image:
* ** mvn clean install -PdockerRefreshImage **: this command refreshes Docker Image (stop Container if exists and refresh Image);
* ** mvn clean install -PdockerRefreshContainer **: this command refreshes Docker Container (stop Container if exists, refresh Image and run new Container);
* ** mvn clean install -PdockerStopContainer **: this command stops Docker Container (stop Container if exists);
* ** mvn clean install -PdockerPushImage **: this command pushes Image to default remote Docker Hub repository 
(stop Container if exists, build Image and push it. ** It requires changes in file m2/settings.xml  **);

Changes in file m2/settings.xml for "push" (credentials to Docker Hub repository):
<server>
	<id>docker.io</id>
	<username>Docker-Hub-Username</username>
	<password>Docker-Hub-Password</password>
</server>
  

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
* ** mvn clean install -DdockerRefreshImage **
* ** mvn clean install -DdockerRefreshContainer **
* ** mvn clean install -DdockerStopContainer **
* ** mvn clean install -DdockerPushImage **