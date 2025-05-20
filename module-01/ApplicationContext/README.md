Application Context
    Is a central part of Spring Application. It holds bean definitions, and contains registry of bean components
    It also allows us to retrieve configured and assembled beans

Types:
* AnnotationConfigApplicationContext
* ClasspathXMLApplicationContext
* AnnotationConfigWebApplicationContext
* FileSystemXMLApplicationContext
* XMLWebApplicationContext


ApplicationContext's job:
* Initiates  beans
* Configures beans and assemble them
* Manage lifecycle of beans
* Is a bean factory - hence allows to fetch beans that exists in application context
* Is a resource loader
* Push events to registered event listeners
* Exposes environment which allows us to resolve properties

Creating ApplicationContext:
* Non-web
  1. AnnotationConfigApplicationContext
  2. ClassPathXMLApplicationContext
  3. FileSystemApplicationContext
  
* Web
  1. Servlet2- web.xml, DispatcherServlet, ContextLoaderListener
  2. Servlet3 - AnnotationWebApplicationContext
  3. Servlet3 - XMLWebApplicationContext
  
* SpringBoot -  @SpringBootApplication--- With springboot we dont have to create ApplicationContext explicitly
  1. SpringBootWebApplication
  2. SpringBootConsoleApplication
  

* Closing Application context
Non web:
  1. Using context.close() - but with this if any exception occurs before the context is closed then it fails
  2. Using context.registerShutDownHook() - prefered way
  3. Using try-with-resource to auto close the context as AnnotationConfigApplicationContext extends AutoClosable
  
Web & SpringBoot: Application context is auto closed when ContextLoadListener is closed ie when web container stops and also it
auto registers to shutdownHook.