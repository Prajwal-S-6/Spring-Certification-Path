**@RequestBody**

* Is used to bind the web request body to the controller method parameter
* HttpMessageConverter will convert the request body to the format required by the method paramter
* Attributes - required, can also use Java8 Optional<>, can use @Valid annotation with it
* Is used on method parameter only


---
**@ResponseBody**

* Is used to serialize the response returned from the Controller method
* Is used when we dont want to return model and view
* This will bind return value to web response body using HttpMessageConverter
* @RestController = @Controller + @ResponseBody
* Can be used on top of Class, method, and on other annotation