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




* Environment Abstraction is part of spring container that mainly involves:
1. Profiles
2. Properties

* Environment interface allows you to resolve properties and also list profiles
* ApplicationContext implements Environment
* Environment Abstraction role in context of profiles is to determine which profiles are currently active, and
  which are activated by default.
* Environment Abstraction role in context of properties is to provide convenient, standarized and generic service
  that allows to resolve properties and also to configure property sources.
* Properties can be from: properties file, JVM property, system property
* Additional property files can be used using @PropertySource


* For standalone applications:
  1. properties can be from properties file
  2. JVM system properties
  3. System env variables
  
* For servlet container spring framework application
  1. properties file
  2. JVM system properties
  3. System env variables
  4. ServletConfig and Servlet context init params
  
* For springboot application
  1. properties file - application.properties, application-{profile}.properties or yaml
  2. @TestPropertySource on tests
  3. Properties attribute in @SpringBootTest
  4. Command line argument
  5. JVM system properties
  6. System env variables
  7. @PropertySource configuration
  8. Default properties using SpringApplication.setDefaultProperties
  

* SpEL reference use cases:
  1. Static fields from class - T(com.example.SomeClass).STATIC_FIELD
  2. Static methods from class - T(com.example.SomeClass).staticMethod()
  3. SpringBean field - @springBeanName.field
  4. SpringBean method - @springBeanName.method()
  5. SpEL variables - #someVariable
  6. Referencing property and method from SpEL variable - #someVariable.property, #someVariable.method()
  7. SpringApplication Env properties - environment['app.file.property']
  8. System properties - systemProperties['app.file.property']
  9. System env variables - systemEnvironment['JAVA_HOME']


* Expressions starting with $ -> is used to reference property in spring environment abstraction
* Expression starting with # -> is parsed as SpEL and evaluated
