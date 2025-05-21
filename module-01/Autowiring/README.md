@Autowired\

* @Autowired(required = true) - default, meaning all the dependencies are required and has to be resolved


* Field injection will be resolved after the instance of bean is created, hence the dependencies wont be available in the dependent bean constructor

* When @Autowired is used on constructor all the parameters has to be resolved, else it will throw NoBeanDefinitionFoundException or NoUniqueBeanDefinitionException


How the bean is identified?\
1. Spring will check for the bean with matching bean type, if found finish.
2. Else it will check for bean/class with @Primary annotation if there are multiple beans of same type
3. If no @Primary, then it will check for qualifying bean based on @Qualifier, @Qualifier("<beanName>") is used where dependency is injected. By default, class name will be bean name\
    however, we can define the bean name on @Component("bean-name"). Or we can use @Qualifier("qualifier-name") at bean definition point and the same at injection point.
4. If no @Qualifier is found then spring will try to match based on bean name.
5. If no bean is found - NoBeanDefinitionFoundException
6. If multiple beans are found  - NoUniqueBeanDefinitionException


* Using @Autowired:
1. On fields: Field injection will be resolved after the instance of bean is created, hence the dependencies won't be available in the dependent bean constructor, will be available in postProcessBeforeInitialization/@PostConstruct
2. On constructor: If there is only one constructor then no need to use @Autowired, but when there are multiple then we need to tell spring which constructor is providing dependency and only that constructor will be invoked
3. 