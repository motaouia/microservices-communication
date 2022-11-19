Spring Boot Microservices Communication Example using RestTemplate

https://www.javaguides.net/2022/10/spring-boot-microservices-communication-using-resttemplate.html

######INTRODUCTION#######
In this tutorial, we will learn how to create multiple Spring boot microservices and how to use RestTemplate class to make Synchronous communication between multiple microservices.

There are two styles of Microservices Communications:

Synchronous Communication
Asynchronous Communication

###########What we will Build?##########
Will create two microservices such as department-service and user-service and we will make a REST API call from user-service to department-service to fetch a particular user department.

POST : "http://localhost:8080/api/departments"
{
	"departmentName" : "IT",
	"departmentAddress" : "SIDI MAAROUF",
	"departmentCode" : "IT101" 
}

GET : http://localhost:8080/api/departments/1

POST : http://localhost:8081/api/users/
{
	"firstName" : "Mohamed",
	"lastName" : "MOTAOUIA",
	"email": "med.motaouia@gmail.com",
    "departmentId" : "1"
}

GET : http://localhost:8081/api/users/1