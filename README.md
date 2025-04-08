# mTLS workshop project

This is a project meant to use in a workshop where you can implement mTLS on some simple web applications that 
interact with each other using REST.

These web applications are:

### System A
A very minimal system acting as a client. From System A, a user wants to make a search to see if a **contract key** 
value matches a contract in System B. Interface is command line, just enter the search term in the terminal where 
the application is running.
Configured to run on port 8081.

### System B
A simple system acting as a server. System B has a database containing contracts. It exposes a REST endpoint to 
search for the contracts based on their **contract key**.
Configured to run on port 8082.

### Middle
Since System A and System B need to be loosely coupled, an integration solution is used to perform the search 
between them. So Middle acts as a server when System A makes a call to it, and as a client when it calls System B.
Configured to run on port 8083.

![](/system_overview.png)

## How to run the application
The applications are running on Spring Boot, so simply run it directly from your IDE or by running
`mvn spring-boot:run` in the terminal.