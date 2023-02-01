DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to implement application in **Java** programming language with usage **Spring Boot** framework which contains HelloWorld service and **Load Balancer** type **retrofit**. If there more then one instance of HelloWorld service then Load Balancer redirects traffic.

**Retrofit** is Load Balancer for Kubernetes.

Project is dockerized so you can use **Kubernetes** to run it.

##### Service
This project consists of following services:
* **Service HelloWorld**: port **8081**. This service provides message and port
* **Service LoadBalancer**: port **8080**. This service redirects traffic to instances HelloWorld, get responses and returns them to final user

##### Flow
The following flow takes place in this project:
1. User via Browser sends request to Service LoadBalancer for content
1. Service LoadBalancer redirects request to Service HelloWorld
1. Service HelloWorld sends back response to LoadBalancer with message and port
1. Service LoadBalancer sends back response to User via browser with it's port and Service HelloWorld port and message

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This project uses following technologies:
* **Java**: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* **Maven**: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* **Git**: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`
* **Spring Boot**: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`
* **Microservices**: `https://docs.google.com/document/d/1j_lwf5L0-yTPew75RIWcA6AGeAnJjx0M4Bk4DrUcLXc/edit?usp=sharing`
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
* Installed **kubectl** (tested on version v4.5.4)

##### Preconditions - Actions
* **Launched** Docker on your local machine
* **Launched** Minikube on your local machine with (as administrator) `minikube start`
* **Connected** Minikube with Docker with (Windows - as administrator): `minikube docker-env` and `minikube docker-env | Invoke-Expression` or with (Linux) `eval $(minikube docker-env)` 
* **Download** source code using Git 
* Open any **Command Line** (for instance "Windonw PowerShell" on Windows OS) tool on **project's folder** (exact localization of project you can check in GIT repositories on page `https://github.com/wisniewskikr/chrisblog-it-docker`)


USAGE
-----

> **NOTE:**  Please open Command Line tool as **administrator** on **main folder of project**.

Usage steps:
1. Connect Minikube and Docker with (Windows) `minikube docker-env | Invoke-Expression`
1. Build package with `mvn clean package -D maven.test.skip`
1. Build Service HelloWorld image with `docker build -f service-helloworld/Dockerfile-Fast -t wisniewskikr/helloworld-image ./service-helloworld`
1. Build Service LoadBalancer image with `docker build -f service-loadbalancer/Dockerfile-Fast -t wisniewskikr/loadbalancer-image ./service-loadbalancer`
1. (Optional) Check images in Minikube:

     * Run Minikube SSH with `minikube ssh`
     * Display Minikube images (expected new images from this project) with `docker images`
     * Close Minikube SSH with `exit`

1. Start HelloWorld service with `kubectl apply -f 1-helloworld.yaml`
1. Start LoadBalancer service with `kubectl apply -f 2-loadbalancer.yaml`
1. (Optional) Check status of services (expected READY 1/1) with `kubectl get pods`
1. Launch LoadBalancer Service in browser with `minikube service service-loadbalancer-show`
1. (Optional) Launch HelloWorld Service in browser with `minikube service service-helloworld-show`
1. Clean up environment:
    
    * Remove HelloWorld service with `kubectl delete -f 1-helloworld.yaml`
    * Remove LoadBalancer service with `kubectl delete -f 2-loadbalancer.yaml`
    * Remove Service HelloWorld image with `docker rmi wisniewskikr/helloworld-image`
    * Remove Service LoadBalancer image with `docker rmi wisniewskikr/loadbalancer-image`