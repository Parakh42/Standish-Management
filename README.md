# Standish-Management

SpringBoot Restful Web Services with Angular 7

Requirements:-
-Spring Tool Suite IDE
-Maven
-Java SDK
-Postman
-Angular 7
-Visual Studio Code

Project Overiview:-
- There are three entities :- Client, Investor, Fund
- A client can have multiple investors
- A investor can manages multiple funds
- Used H2 in-memory database for the application
- Build project using Maven
- Created REST API end points for the following:-
      - To create and update client details
      - To get list of all users
      - To get list of Investors for a particular client
      - To get list of Funds for a particular client
- Build frontend using Angular 7

Unit Tests:-
-Launch Postman
-Set Content-type as application/json
-Type url "localhost:8080"
-To create a new client go to /createClient and method POST
-Enter name and description in JSON format under body section
