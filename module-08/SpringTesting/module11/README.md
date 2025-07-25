**@ContextConfiguration**

* Is used on top of test class indicating it is an integration test. It also tells how Application context should be loaded and configured
    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes={})
* @ContextConfiguration can be used in two modes:
  * Annotation class based
  * XML based


* In Annotation class based, classes field should point to class or list of classes that represents @Configuration with @ComponentScan indicating packages to scan for beans or @Bean definitions.
* In XML based approach, locations fields should point to the xml files which provides bean definitions or componentScan


* We can also configure few things using @ContextConfiguration
  * initializers - list of ApplicationContextInitializers used in cases where manual initialization of context is done
  * loaders - to specify custom ContextLoader, default is DelegatingSmartContextLoader
  * inheritLocations - to tell whether xml locations and classes should be inherited from test superclass, default true
  * inheritInitializers to tell whether initializers should be inherited from test superclass, default true