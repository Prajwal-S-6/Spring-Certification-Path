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
