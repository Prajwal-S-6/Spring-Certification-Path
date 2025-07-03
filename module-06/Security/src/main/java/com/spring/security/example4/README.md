**SecurityContext**

* SecurityContext is an interface in Spring framework, allows us to access Security information associated with current thread of execution
* Interface provides 2 methods - getAuthentication(), setAuthentication()

* SecurityContext can be accessed using SecurityContextHolder, which can be accessed in 3 modes:
  * MODE_THREADLOCAL
  * MODE_INHERITABLETHREADLOCAL
  * MODE_GLOBAL
  

* MODE_THREADLOCAL - allows each thread to access its own SecurityContext, even the child thread gets its own SecurityContext
* MODE_INHERITABLETHREADLOCAL - allows child thread to access the same SecurityContext as Parent, and all other threads gets their own SecurityContext
* MODE_GLOBAL - all the threads in the JVM will get the same SecurityContext, usually used in standalone desktop applications


* Mode of SecurityContextHolder can be changed via:
  * property - spring.security.strategy
  * programmatically - SecurityContextHolder > setStrategyName()
  

* SecurityContext allows us to access currently used Authentication object.
* Authentication object contains following methods:
  * getPrincipal()
  * getAuthorities()
  * getCredentials()
  * getDetails()
  * isAuthenticated(), setAuthenticated() - used internally to check number of re-authentications