PlatformTransactionManager for JPA:
* Spring JPA can work with following PlatformTransactionManager
  * JpaTransactionManager - recommended when we are using single database and single entity manager
  * JtaTransactionManager - recommended when we are using multiple database and multiple entity manager. Or when working with multiple db and other resources like JMS queues.
  
* Usage of JpaTransactionManager in case multiple db/Transactional resources/ Entity managers will cause each transaction to span only one resource.
* Hence, JtaTransactionManager is preferred