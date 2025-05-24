* @Bean attributes
1. name - to specify the bean name, if not set then method name becomes bean name
2. initMethod - method to be called after postProcessBeforeInitialization and InitializeBean::afterPropertiesSet is called
3. destroyMethod - method to be called after postProcessAfterInitialization and DisposableBean::destroy is called
4. alias - @Bean(name= {"name1", "name2"})
5. autowireCandidate - default true, if set to false then wont be considered as bean for autowiring

