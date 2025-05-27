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
* SpEL expressions are evaluated at runtime, and this may lead to performance concerns
    * In spring 4.1 introduced a compiling of expression
    * This results in much faster evaluation
    * This is best useful when referenced types are not changing
    * Compiler type is turned off by default
    * Can be turned on by : **spring.expression.compiler.mode** or ParserConfiguration
* Compiler options are in 3 modes:
    * Default off
    * Immediate - compile upon first expression evaluation
    * Mixed - compiler dynamically switch between interpreted and compiled mode, if exception is thrown during compilation then switch to interpreted and viceversa
* Compiler mode doesnt work where expressions are relying on conversion service
