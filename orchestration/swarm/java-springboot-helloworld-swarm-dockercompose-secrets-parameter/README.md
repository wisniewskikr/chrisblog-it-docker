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
1. Create Docker Swarm Stack with `docker stack deploy -c docker-compose.yml java-springboot-helloworld-stack`
     * (Optional) Check if Stack exists with `docker stack ls`
     * (Optional) Using browser visit `http://localhost:8080`
1. Get **CONTAINER ID** with `docker ps -a`
1. Run command line tool in Container with `docker exec -it {CONTAINER ID} sh`
     * Display secret with `cat /run/secrets/secret_message`
     * Stop command line tool in Container with `exit`
1. Clean up environment 
     * Remove Docker Swarm Stack with `docker stack rm java-springboot-helloworld-stack`
     * Leave Docker Swarm with `docker swarm leave --force`


DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to use **secrets** created as **command line parameter** in **Java Spring Boot** application. This application uses **Docker Swarm** tool and **Docker Compose** and is already deployed as Docker Image in **Docker** public repository.

##### Terminology
Terminology explanation:
* **Java**: object-oriented programming language
* **Spring Boot**: framework for Java. It consists of: Spring + Application Server + Configuration
* **Docker**: tool for developing, shipping, and running applications which are provided as Docker Images and run as Docker Containers
* **Swarm**: it's Docker container orchestration platform for managing containerized services. It uses Services for single Docker Containers and Stacks for multiple Docker Containers
* **Docker Compose**: tool for defining and sharing Docker multi-container applications

##### Flow
The following flow takes place in this project:
1. User via any browser sends request to application Hello World for the content.
1. Application HelloWorld sends back response with JSON containing: message, port and UUID. This response is presented to User via browser.

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
* (Optional) Verified **Docker Image**: `https://hub.docker.com/repository/docker/wisniewskikr/java-springboot-helloworld/general`
* Download **Source Code** (using Git or in any other way) 
* Open any **Command Line** tool (for instance "Windonw PowerShell" on Windows OS) on downloaded **project's main folder**