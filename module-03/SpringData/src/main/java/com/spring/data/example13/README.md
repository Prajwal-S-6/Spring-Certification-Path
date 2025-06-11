@Transactional
* @Transactional annotation can be used on top of method, class, interface, interface method
* When used on top of class/interface all public methods will be part of transaction management
* When used on top of method only public access modifier methods will be part of transaction management
* private, protected, package access modifier methods will not be part of transaction management

*** However in recent spring versions, package and protected methods are part of transaction management due to the use of CGLIB proxy,
which proxies public, package, protected methods