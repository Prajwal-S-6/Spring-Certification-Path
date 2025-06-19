**HandlerMapping and HandlerAdapter**

* The incoming requests is mapped to the controller and method by DispatcherServlet using HandlerMapping and HandlerAdapter components
* HandlerMapping is used during spring initialization to scan classpath for @Controller/@RestController class and methods with one of request mapping - @RequestMapping, @GetMapping etc
* HandlerAdapter is responsible for execution of methods that are identified as candidate for handling requests

* When request is sent in Spring Application:
1. Application server will look for servlet which can handle request based on servlet registration and url patterns. It selects DispatcherServlet.
2. Then DispatcherServlet uses HandlerMapping to find request mapping(@Controller class and methods) information and HandlerAdapter
3. HandlerAdapter takes care of executing the @Controller method that handles the request
4. DispatcherServlet interprets the result from the method execution, renders the view with help of ViewResolver