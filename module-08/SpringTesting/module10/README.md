* Mock frameworks such as Mockito/EasyMocks are used to mock dependencies during unit testing
* It can be used during integration test to check interaction between components
* Mocks are fake objects, pretend to be real object and return desired result.
* It is also used to verify if expected method was indeed called with expected arguments.
* We can inject mocks using annotation, no need of IOC container or context in unit test.


* Using Mockito for Unit test:
  * RunWith(MockitoJUnitRunner.class) or @ExtendWith(MockitoExtension.class)
  * Annotate @InjectMocks on to the target class which has dependencies and needs to be mocked
  * Annotate @Mock to mock the dependencies
  * Use when().thenReturn() to stub the methods
  * Use verify(class).method(args...) to verify expected methods are called


* Mockito in Integration test:
  * RunWith(MockitoJUnitRunner.class) or @ExtendWith(MockitoExtension.class), @ContextConfiguration
  * Create a @Configuration class and Beans  return the mock of original dependency objects.
  * Use this mocks by directly @Autowired into test
  * In the application context there will be 2 beans(Original & mocked - NoUniqueBeanDefinition), use @ActiveProfile to resolve conflict.
  * In SpringBoot we can use @ConditionalOn.. or @TestConfiguration


* In SpringBoot during integration test we use @MockBean/@MockitoBean to mock the original beans.
* @Mock is from mock framework, it creates mock, but injects it only if we add @InjectMocks and will be injected only on to the class.
* @MockitoBean(@MockBean) also creates and injects mock, it injects mock into Application context.
* So any beans which refers to this mocked class via @Autowired gets this mock injected instead of original class
