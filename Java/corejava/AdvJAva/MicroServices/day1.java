Monolith Architecture
======================

=> Developing all functionalities in one single application is called as Monolithic Architecture based application.

		1) Presentation Layer

		2) Business Layer

		3) Data Access Layer

=> Drawbacks with Monolith Architecture

		1) Burden on server

		2) Response Delay 

		3) Single Point of Failure

		4) Technology Dependent

		5) Re-Deploy Entire application


=> To overcome problems of Monolith Architecture, people are using Microservices Architecture.

==================
Microservices
==================

=> It is not a new technology.

=> It is not a new programming language

=> It is not a framework like spring and hibernate

=> It is not a libraray

~~~~~~~~~~~~~~~~~~ It is an Architectural Design Pattern. ~~~~~~~~~~~~~~~~~~~~~~

=> It is universal and anyone can use this architecture to develop their applications.

Note: The main aim of microservices design pattern is to develop application functionalities with loosely coupling.


==============================
Advantages with Microservices
==============================

1) Functionalities are loosely coupled

2) Less Burden on servers

3) Easy Maintenence

4) No Single Point of failure

5) Technology Independent

6) Quick Releases


==============================
Challenges with Microservices
==============================

1) Bounded Context

2) Repeated Configurations

3) Visibility

=> Bounded context means identifying how many microservices we need to develop for one application and deciding which functionality we need to add in which microservice.

=> In Several microserices we need to write same configurations like data source, smtp, kafka, redis etc.

=> In microservice architecture we might not get chance to work with all apis available in the application.


==================
Service Registry
==================

=> It is also called as Service Discovery or Discovery server.

=> Service Registry is used to maintain all Microservices (apis) information at one place.

=> Using service registry we can access below details of all microservices with UI. 

		1) Name

		2) Status (UP or DOWN)
	
		3) URL
	
		4) No.of Instances Available
=> It will provide user interface to get Microservices information.

=> We can use Eureka Server as service registry.

Note: Eureka Server provided by Spring Cloud Libraries.



Service registery 
.....................


steps to deveop service registery (eurek server)
......

eureka server(spring cloud starter netfix-erreka server )
springboot devtools

config @EnableEurekaServer



@springBootApplication
@EnableEurekaServer   // make this prj as springboot application and eureka server
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}   

//no instance runing
http://localhost:8761/  // to access eureka server ui  recomanded for port 


Note-1: If "Service-Registry" project port is 8761 then clients can discover service-registry and will register automatically with service-registry. 	 	

Note-2 : If service-registry project running on any other port number (not 8761) then we have to register clients (microservices) with service-registry manually.

eureka.client.register-with-eureka=false    // project should not register as client , it will act as server not client 



admin server:
.................

=> It is used to monitor and manage all the apis at one place.

=> It provides beautiful user interface to access all apis actuator endpoints at one place.

Ex: health, info, beans, url-mappings, env, loggers, thread dump, heap dump.


monitor and manage all microservices with admin server
admin -server dependcy 
config @EnableAdminServer at steart class
downgrade 3.8 to enable admin server dep
3rd party company codecentric provide admin server dependency with spring boot 2.7.5 and spring boot 3.0.0

eureka server belong dirct from springboot 

2) Configure "@EnableAdminServer" annotation at start class.

3) Change Port Number (Optional)

4) Run the boot application and access Admin Server Dashboard using below URL

		http://localhost:1111/



==================================
Steps to work with Zipkin Server
==================================
=> It is used for distributed tracing of our requests in microservices.

Ex:

1) Which request processed by which microservice.

2) Time taken by microservice to process a request.

3) Which microservices got involved in request processing.


=> It provides beautiful user interface to trace microservices request processing details.





1) Download Zipin Jar file 

	URL : https://zipkin.io/pages/quickstart.html

2) open cmd / gitbash and execute zipkin jar file with below command

		$ java -jar <jar-name>

3) Zipkin Server Runs on Port Number 9411	

4) Access zipkin server dashboard

		URL : http://localhost:9411/

        ================
Config Server
================

=> It is used to load configuration properties from outside of the project.

Note: Instead of keeping properties (datasource, smtp, kafka, redis...) in our application, we can load them from git repo by using config server.

=> Config Server makes our application loosely coupled with properties file or yml file.



 