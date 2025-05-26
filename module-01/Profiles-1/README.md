* @Profile can be configured by:
    * Saying which bean belongs to which profile
    * And which profiles are active, only if the profile is active then the bean instance is created

* @Profile can be added on @Component, @Configuration, @Bean method level
* Profile can be activated by:
  1. Programmatically by using Environment interface - ApplicationContext implements Environment - context.getEnvironment.setActiveProfiles("profile-name")
  2. 