DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to display **Hello World** message, **port FE**, **UUID FE**, **port BE** and **UUID BE** for **multiple** Java applications with **Spring Boot** framework. FE means Front-End application - application which is visible for user. BE means Back-End application - application which is not visible for user. UUID means unique id number for application. All application will be run on **Docker**.

It presents following Docker tool features:
* **Slow Build Image** (but it does not require locally installed Java and Maven) basing on **Dockerfile** and run Container on local computer
* **Fast Build Image** (but it requires locally installed Java and Maven) basing on **Dockerfile-Fast** and run Container on local computer
* Build Image basing on Dockerfile and **push** it to Remote Repository
* **Pull** Image from Remote Repository and run Container on local computer

##### Flow
The following flow takes place in this project:
1. User via any browser sends request to FE application for a content
1. FE application sends request to BE application for a content
1. BE application sends back response with message, BE port and BE UUID to FE application
1. FE application sends back response with message, FE port, FE UUID, BE port and BE UUID to User via browser

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 11.0.16.1). Tool details: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* Installed **Maven** (tested on version 3.8.5). Tool details: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* Installed **Git** (tested on version 2.33.0.windows.2). Tool details: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`
* Installed **Docker** (tested on verison 20.10.21). Tool details: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`


##### Preconditions - Actions
* **Launch** Docker tool on your local machine
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on **project's folder** (exact localization of project you can check in GIT repositories on page `https://github.com/wisniewskikr/chrisblog-it-docker`)


USAGE - FAST BUILD IMAGE AND RUN CONTAINER LOCALLY (FAST BUT REQUIRES LOCALLY INSTALLED JAVA AND MAVEN)
-------------------------------------------------------------------------------------------------------

Usage steps:
1. Build package with `mvn clean package -D maven.test.skip`
1. Build image FE with `docker build -f springboot-helloworld-port-uuid-docker-multiple-fe/Dockerfile-Fast -t springboot-helloworld-port-uuid-docker-multiple-fe-image ./springboot-helloworld-port-uuid-docker-multiple-fe`
1. Build and start container FE with `docker run -d -p 8080:8080 -e helloworld.be.url='http://springboot-helloworld-port-uuid-docker-multiple-be-container:9090' --network helloworld-network --name springboot-helloworld-port-uuid-docker-multiple-fe-container springboot-helloworld-port-uuid-docker-multiple-fe-image`
1. Build image BE with `docker build -f springboot-helloworld-port-uuid-docker-multiple-be/Dockerfile-Fast -t springboot-helloworld-port-uuid-docker-multiple-be-image ./springboot-helloworld-port-uuid-docker-multiple-be`
1. Build and start container BE with `docker run -d -p 9090:9090 --network helloworld-network --name springboot-helloworld-port-uuid-docker-multiple-be-container springboot-helloworld-port-uuid-docker-multiple-be-image`
1. Visit `http://localhost:8080`
1. Display container FE logs (optional)

    * Display logs with **docker logs {container-name}**. For instance with `docker logs springboot-helloworld-port-uuid-docker-multiple-fe-container`
    * Stop displaying logs with `ctrl + c`
1. Display container BE logs (optional)

    * Display logs with **docker logs {container-name}**. For instance with `docker logs springboot-helloworld-port-uuid-docker-multiple-be-container`
    * Stop displaying logs with `ctrl + c`
1. Clean up environment:

    * Stop container FE with `docker stop springboot-helloworld-port-uuid-docker-multiple-fe-container`
    * Remove container FE with `docker rm springboot-helloworld-port-uuid-docker-multiple-fe-container`
    * Remove image FE with `docker rmi springboot-helloworld-port-uuid-docker-multiple-fe-image`
    * Stop container BE with `docker stop springboot-helloworld-port-uuid-docker-multiple-be-container`
    * Remove container BE with `docker rm springboot-helloworld-port-uuid-docker-multiple-be-container`
    * Remove image BE with `docker rmi springboot-helloworld-port-uuid-docker-multiple-be-image`
    * Remove network with `docker network rm helloworld-network`