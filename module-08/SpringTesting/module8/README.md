Shared Context in test refers to:
* Sharing Context definition
* Sharing Context instance


* ContextDefinition can be shared between tests by:
  * Using Base class for all tests, this base class contains @ContextConfiguration, @ActiveProfiles etc and Test class will extend this base class
  * Creating Base interface that contains @ContextConfiguration, @ActiveProfiles,and Test class implements this
  * Creating custom annotation that contains @ContextConfiguration, @ActiveProfiles, and this custom annotation is used on Test class
  * Using TestConfiguration that inherits ApplicationConfiguration
  

* ContextInstance is shared among all test by default as long as request context matches with one in cache.
* Context will be reused as long as @ContextConfiguration(classes, initializers, loaders) and other attributes like @ActiveProfiles, @TestPropertySource etc matches.
* This match is handled by MergedContextConfiguration
* We can use @DirtiesContext to force spring to load new context for every test