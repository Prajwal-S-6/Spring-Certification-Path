Container
    It is a execution environment which provides additional technical services for your code.
    Containers use IoC technique that allows you to focus on business aspects, technical aspects are provided by the container
    Spring provides containers for beans. It manages lifecycle of beans and also provides additional services through ApplicationContext
    

Container lifecycle
1. Application (context) is started
2. Container is created
3. Creates bean definition based on configuration
4. BeanFactoryPostProcessor are processing bean definition
5. Instances of bean is created
6. Resolves beans dependencies, properties, values
7. BeanPostProcessor is called
8. Application runs
9. Application shuts down
10. Context is closed
11. Destruction callback methods are invoked


-------------------------------------------------------------------------------------------------------------------
org.springframework.context.annotation.internalConfigurationAnnotationProcessor\
org.springframework.context.annotation.internalAutowiredAnnotationProcessor\
org.springframework.context.annotation.internalCommonAnnotationProcessor\
org.springframework.context.event.internalEventListenerProcessor\
org.springframework.context.event.internalEventListenerFactory\
applicationConfiguration\
springBean1\
springBean2\
springBean3\
customBeanFactoryPostProcessor\
customBeanPostProcessor\
CustomBeanFactoryPostProcessor::postProcessBeanFactory Listing Beans End\

----------------BeanFactoryPostProcessor ends-----------------------\
CustomBeanPostProcessor::postProcessBeforeInitialization ApplicationConfiguration applicationConfiguration\
CustomBeanPostProcessor::postProcessAfterInitialization ApplicationConfiguration applicationConfiguration\
SpringBean1::constructor\
SpringBean2::constructor\
CustomBeanPostProcessor::postProcessBeforeInitialization SpringBean2 springBean2\
SpringBean2::init\
CustomBeanPostProcessor::postProcessAfterInitialization SpringBean2 springBean2\
SpringBean1::setSpringBean2\
SpringBean3::constructor\
CustomBeanPostProcessor::postProcessBeforeInitialization SpringBean3 springBean3\
SpringBean3::init\
CustomBeanPostProcessor::postProcessAfterInitialization SpringBean3 springBean3\
SpringBean1::setSpringBean3\
CustomBeanPostProcessor::postProcessBeforeInitialization SpringBean1 springBean1\
SpringBean1::init\
CustomBeanPostProcessor::postProcessAfterInitialization SpringBean1 springBean1\
SpringBean1::destroy\
SpringBean3::destroy\
SpringBean2::destroy\
    
