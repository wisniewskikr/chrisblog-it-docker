DESCRIPTION
-----------

##### Goal
The goal of this project is to present how to create **Minikube** Kubernetes **Service** in type **LoadBalancer** for simple "Hello World" **Java** application with **Spring Boot** framework using **Kubernetes** tool.


##### Details

**Minikube** is type of Kubernetes for development or tests on local machine. It creates only one Kubernetes Cluster. It doesn't require external Docker. It has it's own instance.

**Kubernetes Service** is REST object connected with some specific Kubernetes Pod. In this example Kubernetes Service is in type **NodePort** what means that it's **available outside Kubernetes** - for example in browser. Service NodePort **can not connect directly with Kubernetes Pod**. Service NodePort **can connect indirectly with Kubernetes Pod through Kubernetes Deployment**.

**Kubernetes Deployments** creates Kubernetes Pods. You define desired state and Kubernetes Deployments changes the actual state to the desired state. Kubernetes Deployments can also manage **replicas** and check **healthcheck**.  

**Kubernetes Pod** is group of one or more Docker containers. In this example Kubernetes Pod will contain the application displays message "Hello World" in JSON format in a browser. Docker **image** of this application and Docker **container** with this application will be run by Kubernetes tool. We assume that this application already exists and is published as Docker image in some Docker **public repository**. Link to:
* **Source Code** of application: `https://github.com/wisniewskikr/chrisblog-it/tree/master/java-springboot/springboot-helloworld-browser-json-actuator-health`
* **Docker Image** of application: `https://hub.docker.com/repository/docker/wisniewskikr/springboot-helloworld-image`

##### Launch
To launch this application please make sure that the **Preconditions** are met and then follow instructions from **Usage** section.

##### Technologies
This application uses:
* **Spring Boot** framework: `https://docs.google.com/document/d/1mvrJT5clbkr9yTj-AQ7YOXcqr2eHSEw2J8n9BMZIZKY/edit?usp=sharing`


PRECONDITIONS
-------------

##### Preconditions - Tools
* Installed **Operating System** (tested on Windows 10)
* Installed **Java** (tested on version 1.8.0_291). Tool details: `https://docs.google.com/document/d/119VYxF8JIZIUSk7JjwEPNX1RVjHBGbXHBKuK_1ytJg4/edit?usp=sharing`
* Installed **Maven** (tested on version 3.8.5). Tool details: `https://docs.google.com/document/d/1cfIMcqkWlobUfVfTLQp7ixqEcOtoTR8X6OGo3cU4maw/edit?usp=sharing`
* Installed **Git** (tested on version 2.33.0.windows.2). Tool details: `https://docs.google.com/document/d/1Iyxy5DYfsrEZK5fxZJnYy5a1saARxd5LyMEscJKSHn0/edit?usp=sharing`
* Installed **Minikube** (tested on version version 1.26.0). Tool details: `https://docs.google.com/document/d/1GfgN7tJNTIJCaSzexJdR_Lm_S9pF2YykcpgSQzAZWZo/edit?usp=sharing`

##### Preconditions - Actions
* **Start Minikukbe** tool with `minikube start`. More details you can find here: `https://docs.google.com/document/d/1GfgN7tJNTIJCaSzexJdR_Lm_S9pF2YykcpgSQzAZWZo/edit?usp=sharing`
* **Start Minikube Tunnel** in separate Command Line with `minikube tunnel`. More details you can find here: `https://docs.google.com/document/d/1GfgN7tJNTIJCaSzexJdR_Lm_S9pF2YykcpgSQzAZWZo/edit?usp=sharing`
* **Download** source code and open any **Command Line** tool on **project's folder**. You can do it in following way:
    * Open any Command Line tool (for instance "Windonw PowerShell" on Windows OS) and go to folder where you want to download source code 
    * Clone Github repository with `git clone https://github.com/wisniewskikr/chrisblog-it.git`
    * Go to source code folder with `cd chrisblog-it\java-orchestration-kubernetes-minikube\springboot-kubernetes-service-loadbalancer`


USAGE
-----

Usage steps:
1. Create Kubernetes Pod with **kubectl apply -f {file_name}.yaml** . For instance with `kubectl apply -f kubernetes.yaml`
1. (Optional) Check Kubernetes Deployment

    * Display list of Kubernetes Deployments  (expected **READY 1/1**, **UP-TO-DATE 1** and **AVAILABLE 1**) with `kubectl get deployments`
    * Display describe for specific Kubernetes Deployment (expected message ** Scaled up replica set helloworld-deployment-{number} to 1**) with **kubectl describe deployment {deployment_name}** . For instance with `kubectl describe deployment helloworld-deployment`

1. (Optional) Check Kubernetes Pod

    * Display list of Kubernetes Pods (expected **READY 1/1** and **STATUS Running**) with `kubectl get pods`
    * Display describe for specific Kubernetes Pod (expected **Started container helloworld-container**) with **kubectl describe pod {pod_name}** . For instance with `kubectl describe pod helloworld-pod`
    * Display logs of specific Kubernetes Pod with **kubectl logs {pod_name}** . For instance with `kubectl logs helloworld-pod`

1. Check Kubernetes Service

    * Display list of Kubernetes Services (expected **TYPE LoadBalancer** and **EXTERNAL-IP {external-ip}**) with `kubectl get services`
    
1. Display result on browser (take {external-ip} from previous step) with `http:\\{external-ip}:8080`
   
1. Clean up environment:

    * Delete Kubernetes Deployment with **kubectl delete deployment {deployment_name}** . For instance with `kubectl delete deployment helloworld-deployment`
    * Delete Kubernetes Service with **kubectl delete service {service_name}** . For instance with `kubectl delete service helloworld-service`