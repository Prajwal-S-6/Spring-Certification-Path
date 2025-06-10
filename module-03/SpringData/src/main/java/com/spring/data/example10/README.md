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