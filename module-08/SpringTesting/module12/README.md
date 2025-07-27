SpringBoot simplifies unit testing providing:
* @SpringBootTest annotation alternative to @ContextConfiguration, it creates application context by looking for @SpringBootConfiguration, it enables test auto configuration and spring boot features
* Provides @MockBean/@MockitoBean annotation to mock spring beans
* Provides @SpyBean annotation
* Provides @WebMvcTest which loads only web components into context,through which we can test slice of application
* Provides other autoconfiguration to test slice of application - @DataJpaTest, @JdbcTest
* Provides Web Environment with MOCK, RANDOM_PORT, DEFINED_PORT, NONE - used to TestRestTemplate to create web environment for tests
* Based on dependencies added provides beans required for test
* Provides @TestConfiguration to define beans used only in tests
* Provides @ConditionalOn... annotations to enable beans -- @ConditionalOnBean, @ConditionalOnProperty



* spring-boot-starter-test module provides:
  * JUnit
  * Mockito
  * AssertJ
  * SpringBootTest
  * Hamcrest - library of matcher objects
  * SpringTest
  * JSONAssert- An assertion library for JSON
  * JSONPath- XPath for JSON, easy way to access json properties

---
@SpringBootTest
* It automatically searches for @SpringBootConfiguration annotated classes, unless @Configuration class is detected or explicitly specified in @SpringBootTest(classes=)
* In most cases we use @SpringBootApplication which is meta annotation fo @SpringBootConfiguration
* @SpringBootConfiguration is alternative to @Configuration, advantage of using @SpringBootConfiguration is spring auto scans it in tests
* We can override default behavior of scanning, by specifying @SpringBootTest(classes=) or nesting of configuration class inside test class
* We can define web environment with MOCK, RANDOM_PORT, DEFINED_PORT, NONE
* We can define environment properties - @SpringBootTest(properties=) to set environments KEY=VALUE pair before test is executed


* @SpringBootTest(classes=, webEnvironment=, properties=)
* SpringBootTestContextBootStrapper will locate the classes annotated with @SpringBootConfiguration and it will pass it to SpringBootContextLoader which will load the Application context.
* It will search for @SpringBootConfiguration annotated classes from package where Test class is located and will scan this package and all parent package