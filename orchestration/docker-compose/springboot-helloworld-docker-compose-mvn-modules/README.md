DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to display **Hello World** message in a **browser** by **Java** application using **Spring Boot** framework and **Docker Compose** tool. This application is type **mvn module**. Docker Compose enables orchestration of building and running Docker containers.

This project presents following Docker Compose tool features:
* **Slow Orchestration** (it does not require locally installed Java and Maven) basing on **Dockerfile** files and run Containers set on local computer
* **Fast Orchestration** (it requires locally installed Java and Maven) basing on **Dockerfile-Fast** files and run Containers set on local computer

##### Flow
The following flow takes place in this project:
1. User via any browser sends request to application HelloWorld for content.
1. Application HelloWorld returns response with message. This response is presented to User via browser.

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Docker**: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`
* **Docker Compose**: `https://docs.google.com/document/d/1SPrCS5OS_G0je_wmcLGrX8cFv7ZkQbb5uztNc9kElS4/edit?usp=sharing`


PRECONDITIONS
-------------
##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 1.8.0_291). Tool details: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* Installed **Maven** (tested on version 3.8.5). Tool details: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* Installed **Git** (tested on version 2.33.0.windows.2). Tool details: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`
* Installed **Docker** (tested on verison 20.10.21). Tool details: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`

##### Preconditions - Actions
* Launch Docker tool on your local machine
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on **project's folder** (exact localization of project you can check in GIT repositories on page `https://github.com/wisniewskikr/chrisblog-it-docker`)


USAGE - FAST (REQUIRES LOCALLY INSTALLED JAVA AND MAVEN)
--------------------------------------------------------

Usage steps:
1. Build package with `mvn clean package -Dmaven.test.skip`
1. Start application with `docker-compose -f docker-compose-fast.yml up -d --build`
1. Visit `http://localhost:8080`
1. Display container logs (optional)

    * Display logs with **docker logs {container-name}**. For instance with `docker logs helloworld-container`
    * Stop displaying logs with `ctrl + c`
1. Clean up environment with `docker-compose down --rmi all`
    

USAGE - SLOW (DOES NOT REQUIRE LOCALLY INSTALLED JAVA AND MAVEN)
----------------------------------------------------------------

Usage steps:
1. Start application with `docker-compose up -d --build`
1. Visit `http://localhost:8080`
1. Display container logs (optional)

    * Display logs with **docker logs {container-name}**. For instance with `docker logs helloworld-container`
    * Stop displaying logs with `ctrl + c`
1. Clean up environment with `docker-compose down --rmi all` 