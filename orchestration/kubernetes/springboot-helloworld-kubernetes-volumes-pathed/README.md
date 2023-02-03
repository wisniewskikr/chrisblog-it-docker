DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to use **pathed volumes** in **Docker** based on **Java** application using **Spring Boot** framework.

**Docker Volumes** enable mapping folder from container to folder in the computer. Advantages:
* **Persistence**: data still exist after removing container and creating new one
* **Sharing**: data can be shared by different containers

There are three types of volumes:
* **Anonymous**: created by Docker
* **Named**: developer identifies volume by it's name
* **Pathed**: developer indicates exact path of folder on computer where container folder should be mapped

This project is build by using Docker orchestration tool **Kubernetes**.

##### Flow
The following flow takes place in this project:
1. User via any browser sends request to application HelloWorld for not stored as volume content.
1. Application HelloWorld reads data from folder. If it's new container then data are empty and first "Hello World" message is created. This data are sent as response to User via browser.
1. User via any browser sends request to application HelloWorld for stored as volume content.
1. Application HelloWorld reads data from folder. Even if container is new but some data exists on computer then these data are returned. This data are sent as response to User via browser.

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Docker**: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`


PRECONDITIONS
-------------
##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 1.8.0_291). Tool details: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* Installed **Maven** (tested on version 3.8.5). Tool details: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* Installed **Git** (tested on version 2.33.0.windows.2). Tool details: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`
* Installed **Docker** (tested on verison 20.10.21). Tool details: `https://docs.google.com/document/d/1tKdfZIrNhTNWjlWcqUkg4lteI91EhBvaj6VDrhpnCnk/edit?usp=sharing`
* **Docker Compose**: `https://docs.google.com/document/d/1SPrCS5OS_G0je_wmcLGrX8cFv7ZkQbb5uztNc9kElS4/edit?usp=sharing`

##### Preconditions - Actions
* Launch Docker tool on your local machine
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on **project's folder** (exact localization of project you can check in GIT repositories on page `https://github.com/wisniewskikr/chrisblog-it-docker`)


USAGE - PERSISTENCE
-------------------

> **NOTE:**  Please open Command Line tool as **administrator** on **main folder of project**.

Usage steps:
1. Connect Minikube and Docker with (Windows) `minikube docker-env | Invoke-Expression`
1. Build package with `mvn clean package -D maven.test.skip`
1. Build service image with `docker build -f ./Dockerfile-Fast -t wisniewskikr/helloworld-image .`
1. (Optional) Check images in Minikube:

     * Run Minikube SSH with `minikube ssh`
     * Display Minikube images (expected new images from this project) with `docker images`
     * Close Minikube SSH with `exit`

1. Start services with `kubectl apply -f kubernetes.yaml`
1. (Optional) Check status of services with `kubectl get pods`
1. Launch HelloWorld 1 service in browser with `minikube service helloworld-service-1`
1. Visit (expected one Hello World message) `http://{service-1}/not-stored-as-volume`
1. Visit (expected one Hello World message) `http://{service-1}/stored-as-volume`
1. Stop services with `kubectl delete -f kubernetes.yaml`
1. Start services with `kubectl apply -f kubernetes.yaml`
1. Launch HelloWorld 1 service in browser with `minikube service helloworld-service-1`
1. Visit (expected one Hello World message) `http://{service-1}/not-stored-as-volume`
1. Visit (expected **two** Hello World messages) `http://{service-1}/stored-as-volume`
1. Clean up environment:
        
    * Remove Discovery service with `kubectl delete -f kubernetes.yaml`    
    * Remove Service Config image with `docker rmi wisniewskikr/helloworld-image`
    

USAGE - SHARING
---------------

> **NOTE:**  Please open Command Line tool as **administrator** on **main folder of project**.

Usage steps:
1. Connect Minikube and Docker with (Windows) `minikube docker-env | Invoke-Expression`
1. Build package with `mvn clean package -D maven.test.skip`
1. Build service image with `docker build -f ./Dockerfile-Fast -t wisniewskikr/helloworld-image .`
1. (Optional) Check images in Minikube:

     * Run Minikube SSH with `minikube ssh`
     * Display Minikube images (expected new images from this project) with `docker images`
     * Close Minikube SSH with `exit`

1. Start services with `kubectl apply -f kubernetes.yaml`
1. (Optional) Check status of services with `kubectl get pods`
1. Launch HelloWorld 1 service in browser with `minikube service helloworld-service-1`
1. Visit (expected one Hello World message) `http://{service-1}/not-stored-as-volume`
1. Visit (expected one Hello World message) `http://{service-1}/stored-as-volume`
1. Stop services with `kubectl delete -f kubernetes.yaml`
1. Start services with `kubectl apply -f kubernetes.yaml`
1. Launch HelloWorld 2 service in browser with `minikube service helloworld-service-2`
1. Visit (expected one Hello World message) `http://{service-2}/not-stored-as-volume`
1. Visit (expected **two** Hello World messages) `http://{service-2}/stored-as-volume`
1. Clean up environment:
        
    * Remove Discovery service with `kubectl delete -f kubernetes.yaml`    
    * Remove Service Config image with `docker rmi wisniewskikr/helloworld-image`