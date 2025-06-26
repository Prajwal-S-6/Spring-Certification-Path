**@ResponseBody**

* Annotation can be used on op of class, method or on another annotation
* Indicates that the method return value is bound to web response produced by HttpMessageConverter and the return value is serialized into the format in which client has requested
* It is used when implementing backend API services for REST services
* @RestController = @Controller + @ResponseBody