* Reading from property file\

    **@PropertySources**("classpath:application.properties") - single property file
    **@PropertySources**({
        @PropertySource("classpath:application.properties"),
        @PropertySource("file:D:/dev/deb.properties")
})

* Reading the property value based on key(property-name)\
    **@Value**("${spring.application.name}")