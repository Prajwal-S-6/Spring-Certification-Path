**@SpringBootTest**

* Is used for writing Junit integration test
* For writing integration test spring boot simplifies the process eliminating the requirement of application deployment and other connection creation
* @SpringBootTest enables some of spring boot specific features on top of spring test for testing like:
  * Automated context creation through SpringApplication class
  * Web environment for testing - Mocked or Embedded
  * Mocked bean injection via @MockitoBean
  * Spy injection via @SpyBean
  * Auto configuration for mvc testing, jdbc testing , jpa testing

* In JUnit4 we need to use @RunWith(SpringRunner.class) with @SpringBootTest
* But in Junit5 it automatically comes with @ExtendWith(SpringExtension.class)


* @SpringBootTest auto configures ApplicationContext for testing and also tools used for testing
* ApplicationContext is configured by searching for @SpringBootApplication or @SpringBootConfiguration classes based on those bea definition is created


* We can test only slice/part of the application using one of below:
  * @SpringBootTest(classes=)
  * @ContextConfiguration(classes=)
  * @AutoConfigure...   eg. @AutoConfigureMockMvc

* @AutoConfigure allows to configure only specific environment and tools for testing


* Some annotations wrapping @AutoConfigure and make test development easier
  * @WebMvcTest
  * @DataJpaTest
  * @JdbcTest
  * @RestTestClient
  * @JsonTest


* spring-boot-starter-test dependency brings:
  * Junit, Spring Test,SpringBoot Test, AssertJ, Mockito, JSONAssert etc


---
* @SpringBootApplication scans for components in its package and in its subpackages.
* If components are in other package, we need to tell spring boot to scan other packages using - @SpringBootApplication(scanBasePackages/scanBasePackagesClass)
* However, this doesn't work for @Entity and Data Repository classes
* For this along with @SpringBootApplication we need to use - @EnableJpaRepositories(basePackages=) + @EntityScan("com.package.Entities")