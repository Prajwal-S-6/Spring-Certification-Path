* @Value Annotation - to inject scalar or literal values into spring beans



* @Value annotation accepts: 
* Simple value - @Value("simpleValue")
* property reference - @Value("${property-name}")
* SpEL string - @Value("#{20*20}") - evaluated as expression

* @Value can be used on Field, Constructor param, Method - all fields will be injected with same value, method param
* When @Value is added on method then all the method params receives same value
* When @Value is added on method params, then it only works if @Autowired is added on the method name; else it wont

* @Value is used for injecting values into fields.
* Injecting property/environment values into fields, constructor params, method params.
* Injecting result of SpEL expression
* Injecting values from other spring beans
* Injecting values into collection using ConversionService(DefaultConversionService) from property/environment, and other spring beans
* Setting default values, when referenced value from property is missing.



* SpEL is an expression language that allows to query and manipulate objects at runtime.
* SpEL can be used independently using ExpressionParser(SpELExpressionParser) and EvaluationContext(StandardEvaluationContext), or can be used with @Value
* 
