**@Controller vs @RestController**

* @Controller and @RestController are stereotype annotations
* Stereotype annotations are those which indicates the role of the class

* Types of stereotype annotations:
* @Component - generic component, root stereotype, candidate for autoscanning
* @Services - indicates the class handles business logic
* @Repository - indicates class contains DAO logic
* @Controller - indicates class is a Controller in MVC pattern usually returns Model and View for rendering the response
* @RestController - indicates class handles REST services end points, usually producing JSON value
