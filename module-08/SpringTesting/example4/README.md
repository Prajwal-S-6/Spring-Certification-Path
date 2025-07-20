@Mock vs @MockitoBean(@MockBean)

* @Mock is from mockito framework,it is used to create mock for the classes
* This is used by MockitoJUnitRunner,each field annotated with @Mock will have mock created for that class.
* This will only create mock,to inject the mock to the specified class we need to add @InjectMocks on the target class
* @RunWith(MockitoJUnitRunner.class) JUnit4
* @ExtendWith(MockitoExtension.class) JUit5


* @MockitoBean is from spring-boot-test it also creates Mockito mock and injects into ApplicationContext created by @SpringBootTest
* All beans which refers to that mocked class via @Autowired will get mock injected instead of real class.


* Main difference between @Mock and @MockitoBean is @Mock will only create mock, to inject it we need to annotate target class with @InjectMocks and this mock is injected only into the class
* Whereas with @MockitoBean it is auto injected to the ApplicationContext(not just the class). So which ever beans depends on this mocked class via @Autowired will get mocked bean instead of real class