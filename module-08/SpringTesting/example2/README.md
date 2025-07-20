Integration Test

* Integration test should check that atleast few components are providing required functionalities when hey are working together
* We can decide on small number of components that is enough to test the functionality
* Components that are not required for integration test can be omitted or mocked using @MockitoBean


* In SpringBoot we can write integration test using
  * @AutoConfigureMockMvc, MockMvc or @WebMvcTest
  * Embedded container using @SpringBootTest(webEnvironment=), TestRestTemplate, @LocalPort
  

---
@WebMvcTest

* Is used to write integration test only for web layer
* This will create ApplicationContext that will contain only web components and omits all other components
* Other components if required then need be mocked using @MockitoBean
* Or other components can be delivered by @Configuration annotated class using @Import


@WebMvcTest will autoConfigure:
* MockMvc
* @Controller class
* @ControllerAdvice class
* @Converter class
* @Filter class etc


@WebMvcTest supports:
1. Single Controller auto configuration using @WebMvcTest(Controller1.class)
2. Multiple Controller auto configuration by just annotating class with @WebMvcTest