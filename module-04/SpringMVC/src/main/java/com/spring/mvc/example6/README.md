**@GetMapping**

* @GetMapping is a composed annotation of @RequestMapping(method = GET)
* @RequestMapping can be used to map any http methods(GET, PUT, POST)
* @GetMapping is used to may http GET method only
* @RequestMapping can be added on class or method, @GetMapping on methods
* When no method is specified in @RequestMapping then all the http methods are mapped to the controller method
* We can use all the @RequestMapping criteria like (param, header, produces, consumes, path/value) on @GetMapping