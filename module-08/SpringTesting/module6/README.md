* SpringFramework is not used in Unit testing.However spring provides some support for unit testing with some tools/utils:
  * ReflectionUtils - to set value for private fields,methods, manual DI into private fields(@Autowired, @Inject)
  * AopTestUtils
  * MockEnvironment,MockPropertySource
  * ModelAndViewAssert


---
Unit Test: JUnit, Mockito
* Should test single unit of functionality in isolation. Unit of functionality can be a class,method, module.
* In OOP single unit of functionality means a class
* Testing in isolation means it should not depend on environment of execution
* Any dependency  on environment should be mocked, Collaborators/Dependencies should be mocked
* Test should be executed outside of environment, hence IOC container should not be required to create objects


Integration Test: SpringTest, RunWith/ExtendWith, @MockitoBean
* Should test multiple components together to check both the components provide required functionality when working together
* These components can be individually unit tested
* This should check the components provide the required functionality when working together under the environment similar to production environment.
* Here to some of the collaborators/dependencies are mocked, we take few components to perform integration test
* IOC container is used for these kind of tests to provide application context and beans


System Test:
* Should check required system functionality on fully running system
* Environment should be close to production
* Here also IOC container is used but all with real objects


---
* Spring is used in Integration tests for
  * Creating and managing IOC container.
  * Context is created and reused among multiple test to improve test execution time,because integration test contains embedded db, hibernate and other components.

* We can define SpringTest using @ExtendWith(SpringExtension.class) or RunWith(SpringRunner.class)
* @ContextConfiguration is used to configure context
* Support for @Autowired, @Inject
* Support for transaction management- By default all @Transactional annotation are rolled back each test, we can also commit transaction.
* Automatically creates MockMvc


---
Spring annotations for Integration test:
* @ContextConfiguration
* @BootStrapWith- for low level control of how context is created
* @DirtiesContext
  * Class level- BEFORE_CLASS, BEFORE_EACH_METHOD, AFTER_EACH_METHOD, AFTER_CLASS
  * Method level- BEFORE_METHOD, AFTER_METHOD
* @ActiveProfiles
* @TestPropertySource
* @ContextHierarchy({@ContextConfiguration(), @ContextConfiguration())
* @Sql({"/test-schema.sql"}) - indicates sql scripts to execute for test
* @SqlConfig - to define scripts and also metadata
* @SqlGroup - to define multiple sql scripts with config
* @Commit
* @RollBack
* @BeforeTransaction- method to execute before transaction is started
* @AfterTransaction- method to execute after transaction is started