BeanPostProcessor - Is called once the bean instance is created and properties and dependency are resolved\

It is an interface with 2 methods:\
1. postProcessBeforeInitialization
2. postProcessAfterInitialization

Flow:
1. Bean definition is created based on configuration
2. BeanFactoryPostProcessor:: postProcessBeanFactory is invoked
3. Instance of Bean is created
4. Properties and dependency are resolved
5. BeanPostProcessor:: postProcessBeforeInitialization is called
6. @PostConstruct annotated method is called
7. InitializingBean:: afterPropertiesSet method is called
8. @Bean(initMethod = ) is called
9. BeanPostProcessor:: postProcessAfterInitialization is called
