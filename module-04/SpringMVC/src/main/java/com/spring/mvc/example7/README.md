**@RequestParam**

* Is used to bind web request params to @Controller method parameters
* It is used on method arguments
* It can be used to map query params, form data, parts in multipart requests

---
* We can specify following params on @RequestParam
  * name - name of the request param to bind
  * required - default is true; if mentioned param is absent then throws exception. When made false null value will be provided or if defaultValue is mentioned then that will be mapped
  * defaultValue - to specify default value when param is optional and no value is specified

* We can also use Java 8 Optional to mark the parameter as optional

* @RequestParam also supports mapping all request to a map -- localhost:8080/home?country=US&city=NY {country: US; city: NY}
* Also supports mapping multiple values into a Collection -- localhost:8080/home?country=US,IN  [US, IN]