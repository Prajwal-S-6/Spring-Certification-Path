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