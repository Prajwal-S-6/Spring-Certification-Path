Dependency Injection is a pattern where objects do not create their dependencies on itself, instead objects declare dependencies that they need and external object or framework will provide concrete dependencies to objects.

Types of DI:

* Constructor injection
* Setter injection
* Interface injection


Advantages of using dependency injection is:

* Increases code reusability
* Increases code readability
* Increases code maintainability
* Increases code testability
* Reduces coupling

* Advanced:  @ComponentScan(basePackages = "package1, package2",
                        includeFilters = @ComponentScan.Filter(type, pattern),
                        excludeFilters = @ComponentScan.Filter(type, pattern))

1. DI using Java configuration - @Configuration, @Bean
2. DI using annotations - @Component, @ComponentScan, @Autowired
