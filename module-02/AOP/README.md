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
  * execution(com.spring.example.SomeClass.someMethod(...)) -- On matching method execution
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
