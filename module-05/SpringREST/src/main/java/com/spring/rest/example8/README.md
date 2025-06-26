**@RequestMapping**

* Annotation used to specify conditions that request has to match for method to handle that request
* In @RequestMapping we can define following attributes:
  * path/value - uri path for request
  * method - http method
  * params - param that request has to contain
  * headers - header needs to match specified condition
  * produces - MediaType the method handling request produce
  * consumes - MediaType the method handling request can consume
  

---
Composed annotations of @RequestMapping
* @GetMapping
* @PostMapping
* @PutMapping
* @PatchMapping
* @DeleteMapping

* We can use all the attributes defined in @RequestMapping with these too, except for method
* @GetMapping = @RequestMapping(method=GET)