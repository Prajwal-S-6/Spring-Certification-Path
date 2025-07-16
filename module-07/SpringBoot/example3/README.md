* SpringBoot uses autoconfiguration to detect dependencies on the class path
* Based on the defined dependencies it configures the beans to integrate with JPA, Embedded data source, Template engine

* SpringBoot searches for META-INF/spring.factories on classpath that should contain entry for EnableAutoConfiguration, that lists all the autoconfiguration classes provided by autoconfiguration module
* AutoConfiguration class uses @ConditionalOn annotation to specify under which condition certain AutoConfiguration needs to be applied

Examples:
@ConditionalOnBean, @ConditionalOnMissingBean, @ConditionalOnClass, @ConditionalOnMissingClass, @ConditionalOnProperty etc