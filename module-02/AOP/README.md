Aspect Oriented Programming - AOP
Is a Programming paradigm that complements OOP, which separates out cross cutting concerns from the business logic.
* This is used along with the OOP
* This is achieved by adding additional behavior to the code without having to modify the existing :
  * This is achieved by specifying the location of the code where the extra behavior to be added which is a point cut matching a join point
  * And adding the additional logic that should be executed which implements the cross cutting concerns -  called advice

---
* AOP solves code duplication, without having to write common logic across multiple methods
* It is used to add cross cutting concerns like - Logging, Performance logging, Caching, Security, Transaction(commit, rollback) etc
* It avoids mixing unrelated code - example mixing transaction logic code from actual business logic

--- 
* With AOP we create AOP class eg. PerformanceLoggerAspect and annotate the bean with @Aspect
* And @EnableAspectJAutoProxy for aspects to be applied

---
* Join Point
  * Join point in AOP is a point of execution in a program in which the behavior is altered by AOP.
  * In Spring AOP join point is method execution
  * In AOP there can be additional join points like - Constructor execution/invocation, Exception handler etc

---
* PointCut
  * Pointcut is an expression which is added in the Aspect class that is used to match Join point.
  * Additional code called **Advice** is executed in all parts of the code which matches Pointcut
  * Spring uses AspectJ pointcut expression language by default.
  
Example:
  * execution(com.spring.example.SomeClass.someMethod(..)) -- On matching method execution
  * within(com.spring.example.*) -- On match of given types in a given package
  * @within(com.spring.example.annotations.SomeAnnotation) -- match execution of type annotated with given annotation
  * @annotation(com.spring.example.annotations.SomeAnnotation) -- match join point where join point has given annotation


---
* Advice is an additional behavior that is added on to the join point where pointcut matches
* Separate pointcut and advice

---
* Aspect brings together advice and a pointcut.
* It represents a single behavior implemented by advice that will be added on join points matched by pointcut


* Weaving is a process of applying aspects, which modifies code behavior at join points that have matching pointcuts and associated advices.
* During weaving application code and the aspect is combined which enables cross cutting concerns.

* Types of weaving:
  1. Compile time: The byte code is modified during compilation the aspects are applied, the code is modified at join points matching the pointcut and associated advices are applied.
  2. Class load time: The byte code is modified when the class loader loads the classes, then the aspects are applied.
  3. Runtime: Spring AOP follows runtime weaving, where a proxy of original bean is created where aspects are applied. Aspects are applied onto proxy object instead of original one.
  
---
Spring implements cross cutting concerns with usage of Spring AOP module(spring-aspects) which uses AspectJ expression syntax
for Pointcut expression which matches the join point where the code is altered to add additional logic called Advice.\
In Spring AOP join point is always method invocation.

* Spring AOP uses runtime weaving which creates proxy objects where the aspects are applied.
* Spring creates the type of proxy:
  * JDK proxy if the bean implements any interface.
  * CGLIB proxy if bean doesnt implement any interface.
  
* However we can force the spring to create CGLIB proxy by using @EnableAspectJAutoProxy(proxyTargetClass=true)

---
 Limitations of JDK dynamic proxy
* Doesnt support self invocation. Meaning Aspects are not applied when one method invokes another method in the class. Aspects are applied when methods are invoked externally
* Requires the bean to implement interface and only implemented method are proxied, in turn only methods implementing interface will get the aspects applied on pointcut matching the joinpoint.
* Only public methods are proxied

Limitations of CGLIB proxy
* Doesnt support self invocation. Meaning Aspects are not applied when one method invokes another method in the class. Aspects are applied when methods are invoked externally.
* Class for which proxy should be created cannot be final - throws Exception - Cannot subclass final class. Similarly, the methods also cannot be final. As CGLIB proxy BTS creates subclass for the class and overrides the original methods.
* Private methods are not proxied, hence aspects are not applied. public, package, protected methods are proxied and aspects are applied on pointcut matching join point

---
Types of Advices supported by Spring:
1. @Before - executed before the join point matched by pointcut is executed.
2. @After - executed after the join point matched by pointcut is executed.
3. @AfterThrowing - executed when join point matched by pointcut throws the exception
4. @AfterReturning - executed when join point matched by pointcut executes successfully without any exception.
5. @Around - Allows to take full control of join point matched by pointcut. We can change the method args of the join point method execution. Can implement all the above advice using @Around.
              Need to use ProceedingJoinPoint::proceed() to execute the join point method.

---
To enable aspect in Spring
1. Have spring-aspects dependency(aspectjweaver/spring-aop on classpath)
2. Have a bean with @Aspect annotation. Use @Component and @ComponentScan on class annotated with @Aspect. Or create a bean manually using @Bean
3. Have a @Configuration class with @EnableAspectJAutoProxy. Without @EnableAspectJAutoProxy spring will not be able to detect @Aspect class.

* @EnableAspectJAutoProxy will enable the detection of class annotated with @Aspect. Internally @AnnotationAwareAspectJAutoProxyCreator creates the proxy for the classes which are subjected to aspect.
* By creating a proxy, spring intercepts the calls and implements @Before/@After/@AfterThrowing/@AfterReturning/@Around advices.
* @Aspect will not create spring bean on its own, we have to create spring bean using @Component and @ComponentScan or manually using @Bean

---
Pointcut expressions types:
1. execution - matches method execution
    * "execution([visibility modifiers] [return type] [package].[class].method(arguments) [throws exceptions])"
    * [return type] is required, matches the return type returned by matching method.
    * package in class is located, can be omitted if aspect and class in same package. (*) matches all packages, (..)matches all sub packages.
    * class name to match, * for all classes, and also matches subclasses.
    * name of the method to be matched, * for all methods
    * arguments maybe empty for no arguments method, * to match all types of specific argument, (..) to match zero or more arguments
    * matches method that throws specific exception from given list
   
2. within - matches the execution within specified class/classes, can also specify package.
    * "within([package].[class])"
    * package where class is located, * for all package, (..) includes all subpackages
    * class against which match happens, * for all class
   
3. args - matches the execution of methods with the matching arguments
    * args([parameter_type_1, parameter_type_2, ......... parameter_type_n])
    * wildcard * matches all arguments of any type
    * (..) matches zero or more arguments.
   
4. bean - matches the execution of method with matching bean name
    * bean([beanName])
    * name of the spring bean automatically generated by Spring, or manually set
   
5. this - matches the execution against the type of proxy that was generated by Spring AOP
    * this([type])
    * type of proxy generated by Spring.

6. target - matches the execution against the type of target object invoked by the spring generated proxy
    * target([type])
    * type of the target object invoked by the proxy
   
7. @annotation - matches the execution of method annotated with specified annotation type
    * @annotation([annotation_type])
    * annotation type added on the method against which  pointcut expression is matched
   
8. @args - matches the method execution with arguments which types are annotated with specified annotation type
    * @args([annotation_type])
    * annotation type specified on the class which is used as a type in some method argument.
   
9. @within - matches the method execution within class/classes annotated with specified annotation type
    * @within([annotation_type])
    * annotation type added on class within which the methods are matched
   
10. @target - matches the method execution inside the proxied target class annotated with specified annotation.
    * @target([annotation_type])
    * annotation type specified on target class which will be proxied, methods declared in superclass or interface

* Difference between this and target is:
    * this - matches against type of proxy created by spring aop, with jdk proxy type of proxy will be interface type, with cglib type of proxy will be the original class type.
    * target - matches against the type of target object invoked by proxy class, with jdk proxy type of target will be interface type, original class type, with cglib type of target will be original class type.
  
* Difference between @within and @target is:
    * @within - matches against the methods only present in the class annotated with specified annotation.
    * @target - matches against the methods present in the target class methods invoked by proxied class. so matches methods present in base class, even though child class is annotated with specified annotation type
  
* Pointcut expressions can be combined using logical operators like -> ||, &&, !

---
* JoinPoint argument is an object that is used to retrieve additional information about the joinpoint during execution. JoinPoint needs to be the first argument in the Aspect advice method only then spring injects the joinpoint into advice method.
* JoinPoint argument can be used with following advices: @Before, @After, @AfterReturning, @AfterThrowing.
* Is used to retrieve following information:
    * method signature ie join point signature
    * arguments of join point
    * String representation of join point
    * kind eof join point
    * target / this of join point

---
* ProceedingJoinPoint is an object that is used on @Around advice as first argument, this is used to change method arguments, stop method execution entirely during runtime.
* This is used on @Around advice, contains all methods of JoinPoint and additionally:
    * proceed() - executes original method
    * proceed(args) - executes original method with provided args
* Used to conditionally block method execution
* To inject additional arguments
* To remove arguments