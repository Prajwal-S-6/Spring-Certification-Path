@Autowired\

Is used to enable automatic spring bean dependency resolution.

1. It can used on fields
2. Constructor
3. Method

* @Autowired(required = true) - default, meaning all the dependencies are required and has to be resolved


* Field injection will be resolved after the instance of bean is created, hence the dependencies wont be available in the dependent bean constructor

* When @Autowired is used on constructor all the parameters has to be resolved, else it will throw NoBeanDefinitionFoundException or NoUniqueBeanDefinitionException