* Connection lifecycle in JdbcTemplate depends on whether Transaction(@Transactional) is being involved or not
* If JdbcTemplate is used without @Transactional then connection is acquired and release for every method call \
    This is to minimize the amount of time the connection is held
* If JdbcTemplate is used with @Transactional then DataSourceUtils > DataSource > TransactionSynchronizationManager will reuse the connection across every method call as long as transaction is not committed or rolled back.\
    The reason is that connection cannot be closed as long as transaction is in progress, closing will roll back any changes made.
* JdbcTemplate uses getConnection BTS from DataSourceUtils > DataSource