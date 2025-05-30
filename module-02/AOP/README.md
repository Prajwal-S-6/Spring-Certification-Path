Aspect Oriented Programming - AOP
Is a Programming paradigm that complements OOP, which separates out cross cutting concerns from the business logic.
* This is used along with the OOP
* This is achieved by adding additional behavior to the code without having to modify the existing :
  * This is achieved by specifying the location of the code where the extra behavior to be added which is a point cut matching a join point
  * And adding the additional logic that should be executed which implements the cross cutting concerns -  called advice

---
* AOP solves code duplication, without having to write common logic across multiple methods
* It is used to add cross cutting concerns like - Logging, Performance logging, Caching, Security, Transaction(commit, rollback) etc
* It avoids mixing unrelated code - example mixing transaction logic code from actual business logic

--- 

