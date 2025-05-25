* @Value Annotation - to inject scalar or literal values into spring beans



* @Value annotation accepts: 
* Simple value - @Value("simpleValue")
* property reference - @Value("${property-name}")
* SpEL string - @Value("#{20*20}") - evaluated as expression

* @Value can be used on Field, Constructor param, Method - all fields will be injected with same value, method param
* When @Value is added on method then all the method params receives same value
* When @Value is added on method params, then it only works if @Autowired is added on the method name; else it wont
