* @Profile can be configured by:
    * Saying which bean belongs to which profile
    * And which profiles are active, only if the profile is active then the bean instance is created

* @Profile can be added on @Component, @Configuration, @Bean method level
* Profile can be activated by:
  1. Programmatically by using Environment interface - ApplicationContext implements Environment - context.getEnvironment.setActiveProfiles("profile-name")
  2. By setting vm run configuration -> -Dspring.profiles.active=
  3. In springboot by setting property spring.profiles.active or programmatically by new SpringApplicationBuilder(Runner.class).profiles("database").run(args)
  4. In junit using @ActiveProfiles("database")