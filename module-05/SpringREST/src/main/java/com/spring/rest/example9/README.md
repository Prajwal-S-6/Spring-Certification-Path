**@Controller vs @RestController**

* @Controller and @RestController are stereotype annotations
* Stereotype annotations are those which indicates the role of the class

* Types of stereotype annotations:
* @Component - generic component, root stereotype, candidate for autoscanning
* @Services - indicates the class handles business logic
* @Repository - indicates class contains DAO logic
* @Controller - indicates class is a Controller in MVC pattern usually returns Model and View for rendering the response
* @RestController - indicates class handles REST services end points, usually producing JSON value

---
* @Controller - indicates that class is a Controller class in MVC pattern, t is expected to return Model and View that will be used to render the response using Template Engine
* @RestController - indicates that class is used to handle REST services endpoints, it will produce output in expected formats like XML/JSON. Serialized output will be sent to the clients


* @RestController = @Controller + @ResponseBody

* @ResponseBody - indicates that the method returned value should be serialized into response in requested format, and mehod return value is bound to web response
