**HandlerMapping and HandlerAdapter**

* The incoming requests is mapped to the controller and method by DispatcherServlet using HandlerMapping and HandlerAdapter components
* HandlerMapping is used during spring initialization to scan classpath for @Controller/@RestController class and methods with one of request mapping - @RequestMapping, @GetMapping etc
* HandlerAdapter is responsible for execution of methods that are identified as candidate for handling requests

* When request is sent in Spring Application:
1. Application server will look for servlet which can handle request based on servlet registration and url patterns. It selects DispatcherServlet.
2. Then DispatcherServlet uses HandlerMapping to find request mapping(@Controller class and methods) information and HandlerAdapter
3. HandlerAdapter takes care of executing the @Controller method that handles the request
4. DispatcherServlet interprets the result from the method execution, renders the view with help of ViewResolver


---
@RequestMapping
* Allows to specify conditions that request has to match for method to be considered as request handler
* Can be used on class level or method level
* When used on class level all methods will inherit his primary mapping

* We can specify following criteria on @RequestMapping for request
  * path/uri
  * method - http methods GET, POST...
  * params - required params of request
  * headers - headers need to match specified condition
  * produces - mediaType that is produced by method handling the request
  * consumes - mediaType that is consumed by the request
  

---
Other composed annotations
* @GetMapping
* @PostMapping
* @PutMapping
* @PatchMapping
* @DeleteMapping


* We can specify the same criteria as @RequestMapping except for method field
