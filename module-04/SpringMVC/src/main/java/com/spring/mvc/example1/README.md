**MVC**

* MVC is a design pattern which divides the application into three main interconnected components
* Model handles:
  * Data Access, Data Structure, Business logic, CRUD
* View handles:
  * Data representation to the user
* Controller handles:
  * Requests from the user
  * Issues commands and modifies the model
  * Decides which view to be returned to the user.
  


* Spring provides some of the ready to use components that can be used in our application for MVC pattern
* Model - Spring data JPA, Spring JDBC, Spring mongodb etc
* View - Thymeleaf, Groovy markup, JSP, JSTL, Velocity etc
* Controller classes - @Controller, @RestController