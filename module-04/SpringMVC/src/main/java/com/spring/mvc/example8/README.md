**@PathVariable**

* Is used to map parts of URI marked using template variables with the @Controller method parameters
* It is used on method parameters only

---
* With @RequestParam we can specify defaultValue.
* Whereas with @PathVariable there is no default value.
* We can specify name/value, mark @PathVariable as not required
* We can use Java 8 Optional
* We can map all parameters to the map; key will be the template variable name and value will be the url value
* We can map list of values to parameter collection