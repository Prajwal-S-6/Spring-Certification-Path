* Springboot knows what to configure based on AutoConfiguration classes defined in starter modules
* In latest version spring boot searches for META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports for AutoConfiguration classes.
* In older version itt looks into META-INF/spring.factories for AutoConfiguration classes.
* AutoConfiguration classes are classes annotated with @AutoConfiguration and @ConditionalOn... annotations which specifies under which condition the auto configuration class to be loaded
* When the condition is matched, Spring boot provides beans configured in auto configuration class and integrate our application with required technology.


* Starter modules provides set of dependencies and also auto configuration classes

---

* @EnableAutoConfiguration - turns on auto- configuration in spring boot, it tries to guess the spring beans to be configured based on dependencies and AutoConfiguration classes with @ConditionalOn... from starter modules
* When using @SpringBootApplication @EnableAuoConfiguration is added by default