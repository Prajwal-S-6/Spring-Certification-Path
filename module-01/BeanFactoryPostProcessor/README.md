* BeanFactoryPostProcessor - Is a functional interface with single method postProcessorBeanFactory()\
                            this method is invoked when bean definition is discovered and before instance of bean is created ie before constructor is called.\
                            Used to add/modify bean metadata.

* PropertySourcePlaceHolderConfigurer is a BeanFactoryPostProcessor which resolves the value on the fields annotated with \
@Value("${property-name}") - resolves property-name
                            