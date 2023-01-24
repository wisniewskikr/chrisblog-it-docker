DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to implement **communication** between services **inside Kubernetes Pod** using **Java** programming language and **Spring Boot** framework. All Kubernetes configuration is included in file **kubernetes.yaml**.

##### Service
This project consists of following services:
* **Service Storage**: port **9090**. This service storages "Hello World" message
* **Service Display**: port **8080**. This service displays message from Service Storage and ports of Service Display and Service Storage

##### Flow
The following flow takes place in this project:
1. User via Browser sends request to Service Display for content
1. Service Display sends request to Service Storage for message
1. Service Storage sends back message to Service Display
1. Service Display sends message and services ports to User via Browser

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Java**: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* **Maven**: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* **Git**: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`
* **Spring Boot**: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Docker**: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`
* **Kubernetes**: `https://docs.google.com/document/d/1jOsK3Lkbkoq-Xx7Ln9o_ozCt6XpcSElOwu1o2AfQnNc/edit?usp=sharing`
* **Minikube**: `https://docs.google.com/document/d/1GfgN7tJNTIJCaSzexJdR_Lm_S9pF2YykcpgSQzAZWZo/edit?usp=sharing`


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 11.0.16.1)
* Installed **Maven** (tested on version 3.8.5)
* Installed **Git** (tested on version 2.33.0.windows.2)
* Installed **Docker** (tested on version 20.10.21)
* Installed **Minikube** (tested on version v1.28.0)
* Installed **kubectl**

##### Preconditions - Actions
* **Launched** Docker on local machine
* **Launched** Minikube on local machine with command `minikube start`
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on **project's folder** (exact localization of project you can check in GIT repositories on page `https://github.com/wisniewskikr/chrisblog-it-docker`)


USAGE
-----

Usage steps:
1. In Command Line tool run Kubernetes configuration for services with `kubectl apply -f kubernetes.yaml`
1. (Optional) In Command Line tool check Pods status on Minikube Dashboard with `minikube dashboard`
1. In Command Line tool run Display Service in browser with `minikube service display-service`


DOCKER IMAGES BUILD AND DEPLOYMENT (OPTIONAL)
---------------------------------------------

If you want to build and deploy your own Docker Images based on provided source code please proceed with following steps:
1. In Command Line tool build packages with `mvn clean package -D maven.test.skip`
1. In Command Line tool build Docker Image for Service Storage with `docker build -f service-storage/Dockerfile-Fast -t service-storage-image ./service-storage`
1. In Command Line tool tag Docker Image for Service Storage with your own Docker Id with **docker tag service-storage-image {docker-id}/springboot-kubernetes-communication-service-storage-image**. In my case the command would look like: `docker tag service-storage-image wisniewskikr/springboot-kubernetes-communication-service-storage-image`
1. In Command Line tool push tagged Docker Image for Service Storage to your own Docker repository with **docker push {docker-id}/springboot-kubernetes-communication-service-storage-image**. In my case the command would look like: `docker push wisniewskikr/springboot-kubernetes-communication-service-storage-image`
1. In Command Line tool build Docker Image for Service Display with `docker build -f service-display/Dockerfile-Fast -t service-display-image ./service-display`
1. In Command Line tool tag Docker Image for Service Display with your own Docker Id with **docker tag service-display-image {docker-id}/springboot-kubernetes-communication-service-display-image**. In my case the command would look like: `docker tag service-display-image wisniewskikr/springboot-kubernetes-communication-service-display-image`
1. In Command Line tool push tagged Docker Image for Service Display to your own Docker repository with **docker push {docker-id}/springboot-kubernetes-communication-service-display-image**. In my case the command would look like: `docker push wisniewskikr/springboot-kubernetes-communication-service-display-image`