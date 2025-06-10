JDBC Template
* Can participate in already existing transaction.
* It supports both transactions created using @Transactional and also programmatically created transactions.

* JDBCTemplate is able to participate in existing transaction by usage of DataSourceUtils and TransactionSynchronizationManager.
* TransactionalInterceptor and TransactionalAspectSupport uses PlatformTransactionManager together with DataSourceTransactionManager which will set transaction in TransactionSynchronizationManager for JBCTemplate