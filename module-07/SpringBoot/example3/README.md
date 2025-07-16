* SpringBoot uses autoconfiguration to detect dependencies on the class path
* Based on the defined dependencies it configures the beans to integrate with JPA, Embedded data source, Template engine

* SpringBoot searches for META-INF/spring.factories on classpath that should contain entry for EnableAutoConfiguration, that lists all the autoconfiguration classes provided by autoconfiguration module
* AutoConfiguration class uses @ConditionalOn annotation to specify under which condition certain AutoConfiguration needs to be applied

Examples:
@ConditionalOnBean, @ConditionalOnMissingBean, @ConditionalOnClass, @ConditionalOnMissingClass, @ConditionalOnProperty etc

* SpringBootStarter POM is a maven module hat represents empty jar with set of dependencies required to work with specific technologies like jpa, embedded database, embedded container
* It also provides autoconfiguration to create beans required to integrate with technologies.