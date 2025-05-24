* Proxy object - Are objects to add additional functionality to the object without modifying the original object. Useful for adding logging, Security etc

* Manual proxy  - Create a proxy object/class add extra logic and call the original object method. With manually creating proxy object \
                    there will be lot of boiler plate code to be written
* JDK dynamic proxy - Used when target object implements interface.
                      Create a proxy object by implementing InvocationHandler & overriding invoke method.
                      Use Proxy.newProxyInstance(classLoader, Interfaces, InvocationHandler)
* CGLIB proxy - Used when target object does not implements interface. 
                  Create a proxy object by implementing MethodInterceptor and overriding intercept method.
                  Use Enhancer to create a proxy object


1. JDK proxy works on object only which implements an interface
2. Only interface methods will be proxied
3. No support for self invocation meaning if one method invokes another method then it wont be invoked from proxy
4. CGLIB proxy doesnt support final classes and final methods, And no self invocation

* Disadvantages of using proxy object:
1. Hard to debug the code
2. Need to use unchecked exception if original method doesnt use any
3. May cause performance issue if I/O is used in proxy invocation like in (invoke or intercept methods)


* Spring under the hood uses CGLIB proxy to create proxy objects on singleton bean on ApplicationConfig class(ie bean created in @Configuration class), by creating a subclass on the original object
* Hence @Configuration class cannot be final and methods also cannot be final