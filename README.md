# Microservices
Spring Boot Microservices labs on K8s

1. Install Docker Desktop and enable kubernetes service 

Note : For new versions of Docker Desktop, run the below command

Spring Cloud Kubernetes requires access to Kubernetes API in order to be able to retrieve a list of addresses of pods running 
for a single service. If you use Kubernetes you should just execute the following command:

> kubectl create clusterrolebinding admin --clusterrole=cluster-admin --serviceaccount=default:default

2. execute the below steps to run the applications on K8s    	  	  
kubectl create deployment  simple-rest-api --image=jbossramana/microservices:simple   
kubectl expose deployment simple-rest-api --type=LoadBalancer --port=8080   
kubectl create deployment  other-rest-api --image=jbossramana/microservices:other   
kubectl expose deployment  other-rest-api --type=LoadBalancer --port=8081   

* Take a replication controller, service or pod and expose it as a new Kubernetes Service
* 
3. Test the appliction url's  

http://localhost:8080/simple  
http://localhost:8081/other     [this service calls simple service using Ribbon Client and K8s service registry]  

Note:
problem:  kubectl shows an external IP as "pending," it typically means that the Kubernetes service type is trying to provision an external IP but hasn't succeeded yet
solution :
kubectl port-forward:
kubectl port-forward svc/simple-rest-api 8080:8080 
kubectl port-forward svc/other-rest-api 8081:8081


4. Explain K8s commands 

kubectl  explain deployment(s)   
kubectl  explain pod(s)    
kubectl  explain service(s)   

5. K8s commands to get deployment, service and pods information :

kubectl get pod(s)  
kubectl get service(s)  
kubectl get deployment(s) 
kubectl get event(s)  
kubectl get replicaset(s)

6. To edit the deployment 
kubectl edit deployment simple-rest-api #minReadySeconds: 15  


7. K8s commands to delete the deployment and services  
kubectl delete service  other-rest-api  
kubectl delete deployment  other-rest-api 

8. To scale the application    
kubectl  scale deployment simple-rest-api --replicas=3  

To autoscale: 
kubectl autoscale deployment simple-rest-api --max=5 --cpu-percent=50 

9. Finding a Pod’s Cluster IP 
kubectl get pod -o wide 

10. Finding a Service’s IP 
kubectl get service --all-namespaces  

11. Other useful K8s commands 

kubectl explain pods      
kubectl describe pod simple-rest-api-678ddff668-d9pmt      
kubectl get componentstatuses    
kubectl get all   
kubectl get all -o wide    
kubectl rollout history deployment simple-rest-api    
kubectl logs simple-rest-api-678ddff668-d9pmt   
kubectl delete all -l app=hello-world-rest-api     
kubectl delete all -l app=simple-rest-api 


Steps to install Docker in windows 10 professional:
---------------------------------------------------

1. Enable virtualization @ BIOS 
2. In windows -> Advanced settings -> Advanced -> Performance -> Data Execution Prevention -> 
   Turn on DEP for all programs and sevices except those i select 
3. uncheck Hyper-V
4. uncheck Windows Hypervisor Platform
5. uncheck Virtual Machine Platform
6. uninstall vmware
7. restart the server
8. enable Hyper-V
9. restart the server
10. Install docker desktop


Steps to enable K8s and dashboard
--------------------------------

1. right click -> docker-desktop  
2. select settings  
3. kubernetes -> select all options 


Verify the Kubectl
------------------

kubectl version

Setting up Kubernetes Dashboard
-------------------------------

kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v1.10.1/src/deploy/recommended/kubernetes-dashboard.yaml

We can access Dashboard using the kubectl command-line tool by running the following command:

kubectl proxy
Starting to serve on 127.0.0.1:8001

using curl
----------

curl http://localhost:8001/api


access from browser
-------------------

Go to http://localhost:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:/proxy/ on Browser 


Run the below command to set token:
-----------------------------------

kubectl apply -f dashboard-adminuser.yml  
kubectl apply -f admin-role-binding.yml

To get the token
-----------------

kubectl -n kube-system describe secret    
$(kubectl -n kube-system get secret | grep admin-user | awk '{print $1}')

Copy the data -> token
In the browser => select token option -> paste the above token







