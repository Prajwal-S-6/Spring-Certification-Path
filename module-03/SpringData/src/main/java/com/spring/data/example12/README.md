@EnableTransactionManagement
* @EnableTransactionManagement is used on top of @Configuration class which enables transaction management in spring by use of @Transactional
* When @EnableTransactionManagement is used TransactionalInterceptor and TransactionalAspectSupport proxies the @Transactional methods
* These classes will use PlatformTransactionManager to manage transaction like getting connection, commit, rollback