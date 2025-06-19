**@Controller**

* Is used on class level to indicate that it is a Controller class in MVC design pattern.
* And it should be considered as candidate by DispatcherServlet for handling requests, when DispatcherServlet searches for component to delegate the request
* @Controller is special type of @Component which will enable Spring to autodetect controllers during classpath scanning
* @Controllers have method signatures that helps in mapping uri like
  * @RequestMapping, @GetMapping, @PostMapping, @PutMapping, @PatchMapping, @DeleteMapping