USAGE
-----

> Please be aware that following tools should be installed and run on your local PC: **Docker**. 

> Please **clone/download** project and then open **project's main folder** in your favorite **command line tool** and then **run commands below**. 

Usage steps:
1. Init Docker Swarm with `docker swarm init`
     * (Optional) Check if Swarm is active with `docker info`
     * (Optional) Check if Node exists with `docker node ls`
1. Create secret as parameter with `echo "Secret Hello World!" | docker secret create secret_message -`
     * (Optional) Verify Secret with `docker secret ls`
     * (Optional) Verify Secret with `docker secret inspect secret_message`
1. Create Docker Swarm Service with `docker service create --name java-springboot-helloworld-service --publish 8080:8080 --secret secret_message  wisniewskikr/java-springboot-helloworld`
     * (Optional) Check if Service exists with `docker service ls`
     * (Optional) Using browser visit `http://localhost:8080`
1. Get **CONTAINER ID** with `docker ps -a`
1. Run command line tool in Container with `docker exec -it {CONTAINER ID} sh`
1. Display secret with `cat /run/secrets/secret_message`
1. Stop command line tool in Container with `exit` 
1. Clean up environment 
     * Remove Docker Swarm Service with `docker service rm java-springboot-helloworld-service`
     * Remove Secret with `docker secret rm secret_message`
     * Leave Docker Swarm with `docker swarm leave --force`


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to use **secrets** created as **command line parameter** in **Java Spring Boot** application. This application is deployed as Docker Image in **Docker** public repository using **Docker Swarm** tool.

> **NOTE** Please be aware that **secrets in Docker Swarm work in specific way**. Secrets are not values but files in specific location - **/run/secrets**. And your **application has to read these Secrets from this location** to get secret values.

##### Terminology
Terminology explanation:
* **Java**: object-oriented programming language
* **Spring Boot**: framework for Java. It consists of: Spring + Application Server + Configuration
* **Docker**: tool for developing, shipping, and running applications which are provided as Docker Images and run as Docker Containers
* **Docker Swarm**: it's Docker container orchestration platform for managing containerized services
* **Docker Swarm Secrets**: this feature enables hiding values of some sensitive data like passwords, secret keys etc.

##### Flow
The following flow takes place in this project:
1. User via any browser sends request to application Hello World for the content.
1. Application HelloWorld sends back response with JSON containing: message, port and UUID. The messege is stored as secret in Docker Swarm. This response is presented to User via browser.

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Java**: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* **Maven**: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* **Git**: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`
* **Spring Boot**: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Docker**: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`
* **Swarm**: `https://docs.google.com/document/d/1BgSVPd788hW_XV4EqXNkNxSXqvRTiNVgQKnJdavjbtQ/edit?usp=sharing`


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Docker** (tested on version 20.10.23)

##### Preconditions - Actions
* (Optional) Verified **Java Spring Boot Source Code**: `https://github.com/wisniewskikr/java-springboot-helloworld`
* (Optional) Verified **Java Spring Boot Docker Image**: `https://hub.docker.com/repository/docker/wisniewskikr/java-springboot-helloworld/general`
* Download **Source Code** (using Git or in any other way) 
* Open any **Command Line** tool (for instance "Windonw PowerShell" on Windows OS) on downloaded **project's main folder**