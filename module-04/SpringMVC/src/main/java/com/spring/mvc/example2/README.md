**DispatcherServlet**

* Dispatcher servlet is an internal spring mvc component which implements HttpServlet from java servlet API and front controller design pattern.
* It is used to handle all the requests to the application based on servlet mapping.
* Delegates received requests to the Controllers
* Uses view resolvers to resolve view pointed out by Controller
* Produces response which is then sent to the user
* Handles shared concerns like exception matching, error handling, Security etc


---
Front Controller Design pattern:
* Allows us to implement shared algorithm for entire application
* For handling/processing request
* For handling shared concerns

---
Servlet technology
* Servlet is a java technology used to create web application using application server
* It is nothing but set of interfaces, classes and documentation allowing us to extend capabilities of application server
* Servlet is protocol independent, but most commonly used for Http
* Servlet can be configured in web.xml or with annotations in code
* Servlet registration requires url patterns which informs application server which requests should be mapped to which servlet
    /app-a/*  ----> servlet1
    /app-b/*  ----> servlet2