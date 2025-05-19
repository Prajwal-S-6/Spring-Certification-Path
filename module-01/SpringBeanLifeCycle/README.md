SpringBean Lifecycle

* Context is created
1. When application starts -> Context is created, in turn the container.
2. SpringBean definition is created based on spring bean configuration
3. BeanFactoryPostProcessor is invoked

* Bean is created
1. Instance of bean is created -- ie constructor gets called
2. Dependencies, properties, values are set/resolved
3. BeanPostProcessor:: postProcessBeforeInitialization is called
4. @PostConstruct annotated method is called
5. InitializingBean:: afterPropertiesSet method is called
6. @Bean(initMethod=) is called
7. BeanPostProcessor:: postProcessAfterInitialization is called

* Bean is ready to use

* Bean is destroyed
1. @PreDestroy annotated method is called
2. DisposableBean:: destroy method is called
3. @Bean(destroyMethod=) is called