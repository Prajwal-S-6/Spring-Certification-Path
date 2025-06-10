Transaction is enabled in Spring framework by following steps:

1. We need to enable transaction management by adding @EnableTransactionManagement on top of @Configuration class
2. Create a bean method in @Configuration class the returns the bean which implements PlatformTransactionManager.
3. Examples of PlatformTransactionManagers are:
   * DataSourceTransactionManager
   * JtaTransactionManager
   * JpaTransactionManager
4. Add @Transactional annotation on methods or class that should be part of transaction management.

* In SpringBoot we only use @Transactional on top of methods or class to ber part of transaction management
* Transaction starts from beginning of the method and commits the transaction when method is executed successfully.
* If any exception then the  transaction is rolled back.
* However, this behavior is controlled by propagation type setting on @Transactional

In @Transactional annotation we can configure:

1. Define exception classes for which rollback should happen
2. Define exception classes for which rollback should not happen
3. Timeout for transaction
4. TransactionManger
5. Propagation type
6. Isolation level
7. Readonly flag


---
* PlatformTransactionManager is an interface used by SpringAOP Transaction management, to create, commit and rollback transaction
* It has getTransaction() - returns currently active transaction or creates new one
* commit() - to commit transaction or rollback if it was marked for rollback
* rollback() - to rollback the transaction