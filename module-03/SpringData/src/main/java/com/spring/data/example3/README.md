Template Design pattern:
* Is a behavioral design pattern which allows to encapsulate algorithm or main flow, in a way to achieve customization and code reusability
* It is achieved by creating a abstract class which contains the algorithm or main flow, the subclasses provide the implementation/customize for the steps in the main flow
* It is used to achieve code reusability. However since it is using inheritance it limits the flexibility.
* Consider Strategy Design pattern which will give similar result. This uses Composition over inheritance

---
* Jdbc Template is a class located in org.springframework.jdbc.core package
* Goal of this class is to simplify the use of jdbc by providing implementation for jdbc workflow. Leaving application to provide SQL statements and resultset execution
* Code that interacts with JdbcTemplate needs to provide implementation for callback interfaces which allows specific steps of JDBC workflow customization
  * PreparedStatementCreator
  * ResultSetExtractor
  * PreparedStatementSetter
  * RowMapper