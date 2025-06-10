Transaction
* Transaction is a cross-cutting concern in Spring and it is implemented using @Transactional annotation
* If @Transactional annotation is present on top of method or class then all the methods are proxied by TransactionalInterceptor and TransactionalAspectSupport.
* These classes will interact with PlatformTransactionManager interface to commit the transaction upon successful execution of method, else will rollback in case of exception.
* This behavior is dependent on Isolation level and propagation type set on @Transactional annotation