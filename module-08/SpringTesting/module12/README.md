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
