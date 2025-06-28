* We need spring-webmvc on our classpath for REST API to work
* Even though it is not needed at compile time, it is needed at runtime for REST API to work
* @RestController, @RequestMapping, @ResponseBody all these ar part of spring-web module and not spring-webmvc
* But to identify the right controller for the request we need DispatcherServlet which is part of spring-webmvc module
* Hence we need spring-webmvc in our classpath