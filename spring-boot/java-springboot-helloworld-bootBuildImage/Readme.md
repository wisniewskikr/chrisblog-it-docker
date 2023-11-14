USAGE JAVA
----------

> Please be aware that following tools should be installed on your local computer: **Gradle**, **Git** and **Docker**. Docker tool has to be **up and running**.  

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**. 

Usage steps:
1. In a command line tool build Docker image with `gradle bootBuildImage`
1. In a command line tool start Docker contaneir with `docker run -d -p 8080:8080 --name java-springboot-helloworld-bootbuildimage-container java-springboot-helloworld-bootbuildimage:0.0.1-SNAPSHOT`
1. In a browser visit `http://localhost:8080`
1. Clean up environment 
     * In a command line tool stop and remove Docker container with `docker rm -f java-springboot-helloworld-bootbuildimage-container`
     * In a command line tool stop and remove Docker image with `java-springboot-helloworld-bootbuildimage:0.0.1-SNAPSHOT`


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to **dockerize** an application with usage build tool **Gradle - Groovy** in **Java** programming language with usage **Spring Boot** framework. Dockerize means that Docker image will be created and Docker container will be run with application.

##### Terminology
Terminology explanation:
* **Java**: object-oriented programming language
* **Spring Boot**: framework for Java. It consists of: Spring + Container + Configuration
* **Gradle - Groovy**: tool for build automation which uses Groovy programming language
* **Git**: tool for distributed version control
* **Docker**: tool for developing, shipping, and running applications which are provided as Docker Images and run as Docker Containers

##### Flow
The following flow takes place in this project:
1. User via any browser sends request to application Hello World for the content.
1. Application HelloWorld sends back response.

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Java**: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* **Gradle**: `https://docs.google.com/document/d/16-daDFIYs4wZT-vsrrrV4nDD6XooYh2ageJkgY8eUQU/edit?usp=sharing`
* **Git**: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`
* **Spring Boot**: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Docker**: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 11)
* Installed **Java** (tested on version 17.0.5)
* Installed **Gradle** (tested on version 8.4)
* Installed **Git** (tested on version 2.33.0.windows.2)
* Installed **Docker** (tested on version 20.10.23)


##### Preconditions - Actions
* Download **Source Code** (using Git or in any other way) 
* Open any **Command Line** tool (for instance "Windonw PowerShell" on Windows OS) on downloaded **project's main folder**