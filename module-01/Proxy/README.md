* Proxy object - Are objects to add additional functionality to the object without modifying the original object. Useful for adding logging, Security etc

* Manual proxy  - Create a proxy object/class add extra logic and call the original object method. With manually creating proxy object \
                    there will be lot of boiler plate code to be written
* JDK dynamic proxy - Create a proxy object by implementing InvocationHandler & overriding invoke method.
                        Use Proxy.newProxyInstance(classLoader, Interfaces, InvocationHandler)