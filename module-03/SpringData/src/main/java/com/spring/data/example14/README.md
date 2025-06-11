Declarative transaction management
* Means instead of managing transactions manually through code, we annotate the methods with @Transactional which should be part of transaction management.
* Manually handling transaction means creating connection, committing, roll back and closing connection manually through code.
* Instead, with declarative transaction management we just annotate method with @Transactional, BTS PlatformTransactionManager will handle the connection, commit and rollback