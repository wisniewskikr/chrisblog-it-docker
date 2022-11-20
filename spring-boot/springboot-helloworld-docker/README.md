DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to display **Hello World** message in a **browser** by **Java** application using **Spring Boot** framework and **Docker** tool. It presents following Docker tool features:
* **Slow Build Image** (but it does not require locally installed Java and Maven) basing on **Dockerfile** and run Container on local computer
* **Fast Build Image** (but it requires locally installed Java and Maven) basing on **Dockerfile-Fast** and run Container on local computer
* Build Image basing on Dockerfile and **push** it to Remote Repository
* **Pull** Image from Remote Repository and run Container on local computer

##### Flow
The following flow takes place in this project:
1. User via any browser sends request to application HelloWorld for content.
1. Application HelloWorld returns response with message. This response is presented to User via browser.

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`


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


USAGE - FAST BUILD IMAGE AND RUN CONTAINER LOCALLY (FAST BUT REQUIRES LOCALLY INSTALLED JAVA AND MAVEN)
-------------------------------------------------------------------------------------------------------

Usage steps:
1. Build package with `mvn clean package`
1. Build image with **docker build -t {image-name} .** . For instance with `docker build -f Dockerfile-Fast -t springboot-helloworld-docker-image .`
1. Build and start container with **docker run -d -p {port}:{port} --name {container-name} {image-name}**. For instance with `docker run -d -p 8080:8080 --name springboot-helloworld-docker-container springboot-helloworld-docker-image`
1. Visit `http://localhost:8080`
1. Display container logs (optional)

    * Display logs with **docker logs {container-name}**. For instance with `docker logs springboot-helloworld-docker-container`
    * Stop displaying logs with `ctrl + c`
1. Clean up environment:

    * Stop container with **docker stop {container-name}**. For instance with `docker stop springboot-helloworld-docker-container`
    * Remove container with **docker rm {container-name}**. For instance with `docker rm springboot-helloworld-docker-container`
    * Remove image with **docker rmi {image-name}**. For instance with `docker rmi springboot-helloworld-docker-image`
    

USAGE - SLOW BUILD IMAGE AND RUN CONTAINER LOCALLY (SLOW BUT DOES NOT REQUIRE LOCALLY INSTALLED JAVA AND MAVEN)
---------------------------------------------------------------------------------------------------------------

Usage steps:
1. Build image with **docker build -t {image-name} .** . For instance with `docker build -t springboot-helloworld-docker-image .`
1. Build and start container with **docker run -d -p {port}:{port} --name {container-name} {image-name}**. For instance with `docker run -d -p 8080:8080 --name springboot-helloworld-docker-container springboot-helloworld-docker-image`
1. Visit `http://localhost:8080`
1. Display container logs (optional)

    * Display logs with **docker logs {container-name}**. For instance with `docker logs springboot-helloworld-docker-container`
    * Stop displaying logs with `ctrl + c`
1. Clean up environment:

    * Stop container with **docker stop {container-name}**. For instance with `docker stop springboot-helloworld-docker-container`
    * Remove container with **docker rm {container-name}**. For instance with `docker rm springboot-helloworld-docker-container`
    * Remove image with **docker rmi {image-name}**. For instance with `docker rmi springboot-helloworld-docker-image`

    
USAGE - BUILD IMAGE AND PUSH IT TO REMOTE REPOSITORY
----------------------------------------------------

Usage steps:
1. Build package with `mvn clean package`
2. Build image with **docker build -t {image-name} .** . For instance with `docker build -f Dockerfile-Fast -t springboot-helloworld-docker-image .`
3. Tag image with **docker tag {image-name} {docker-id}/{image-name}**. For instance with `docker tag springboot-helloworld-docker-image wisniewskikr/springboot-helloworld-docker-image`
4. Push image to remote repository with **docker push {docker-id}/{image-name}** . For instance with `docker push wisniewskikr/springboot-helloworld-docker-image`
5. Check remote repository with `https://hub.docker.com`. Log in to your **docker-id** account and check that image with **{image-name}** exists there. For instance `springboot-helloworld-docker-image`
6. Clean up environment:

    * Remove tagged image with **docker rmi {docker-id}/{image-name}**. For instance with `docker rmi wisniewskikr/springboot-helloworld-docker-image`
    * Remove image with **docker rmi {image-name}**. For instance with `docker rmi springboot-helloworld-docker-image`
    * Remove image with name **{image-name}** from your **docker-id** remote repository `https://hub.docker.com`. For instance `springboot-helloworld-docker-image`.


USAGE - PULL IMAGE FROM REMOTE REPOSITORY AND RUN CONTAINER LOCALLY
-------------------------------------------------------------------

Usage steps:
1. Pull image from remote repository with **docker pull {docker-id}\{image-name}**. For instance with `docker pull wisniewskikr\springboot-helloworld-docker-image`
2. Start container with **docker run -d -p {port}:{port} --name {container-name} {docker-id}/{image-name}**. For instance with `docker run -d -p 8080:8080 --name springboot-helloworld-docker-container wisniewskikr/springboot-helloworld-docker-image`
3. Visit `http://localhost:8080`
4. Display container logs (optional)

    * Display logs with **docker logs {container-name}**. For instance with `docker logs springboot-helloworld-docker-container`
    * Stop displaying logs with `ctrl + c`
5. Clean up environment:

    * Stop container with **docker stop {container-name}**. For instance with `docker stop springboot-helloworld-docker-container`
    * Remove container with **docker rm {container-name}**. For instance with `docker rm springboot-helloworld-docker-container`
    * Remove image with **docker rmi {docker-id}/{image-name}**. For instance with `docker rmi wisniewskikr/springboot-helloworld-docker-image`