SelfInvocation of @Transactional methods

* WKT JDKProxy and CGLIB proxy doesnt support self invocation, ie for the methods to be proxied the method has to be invoked externally not from the same class
* Similarly when one method annotated with @Transactional calls another method annotated with @Transactional from same class, TransactionInterceptor will not proxy that method which is getting called, as it wont be proxied

* However, we can enable self-invocation by using ASPECTJ proxy instead of spring-proxy
  * By adding spring-aspects dependency
  * And setting advice mode as ASPECTJ -- @EnableTransactionManagement(mode = AdviceMode.ASPECTJ)