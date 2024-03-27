# msaproj
The project is an online medicine ordering web application that utilises a 
microservices architecture to enhance modularity and scalability. This system is 
developed using Spring Boot, providing a robust framework for creating each 
microservice. The application comprises several independently deployable 
microservices, each responsible for a specific aspect of the application's functionality. 

Login Service: It manages user registration, login, and profile management. New 
users can sign up by providing their personal details, and registered users can log in 
to access their accounts. This service interfaces with the User DB to store and retrieve 
user information securely. 

Order Service: Once logged in, users have the ability to place orders for their 
medicines. The Order Service takes the user's order details, validates them, and 
persists them to the Order DB. It ensures that the inventory levels are updated and 
may also communicate with other services to fulfil the order, such as payment 
processing or notification services.

![image](https://github.com/shre19ya/msaproj/assets/148367500/d575021a-2437-4b1b-90a3-c474eab04f3e)
