**SecurityContext**

* SecurityContext is an interface in Spring framework, allows us to access Security information associated with current thread of execution
* Interface provides 2 methods - getAuthentication(), setAuthentication()

* SecurityContext can be accessed using SecurityContextHolder, which can be accessed in 3 modes:
  * MODE_THREADLOCAL
  * MODE_INHERITABLE_THREADLOCAL
  * MODE_GLOBAL
  
