We can access the properties from property file using:

1. @Value("{property.name}")
2. @ConfigurationProperties(prefix="app") & @EnableConfigurationProperties(ConfigPropertiesClass.class)
3. Injecting Environment object and environment.getProperty("property.name")