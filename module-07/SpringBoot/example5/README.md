* SpringBoot looks for properties file i following places in following order:

1. Profile specific:
   * Outside Jar  application-{profile}.properties or .yaml in /config subdirectory or in current directory
   * Inside Jar application-{profile}.properties or .yaml in /config package on classpath or in classpath root package

2. Application specific:
    * Outside Jar  application.properties or .yaml in /config subdirectory or in current directory
    * Inside Jar application.properties or .yaml in /config package on classpath or in classpath root package
