* SpringBoot looks for properties file in following places in following order:

1. Profile specific:
   * Outside Jar  application-{profile}.properties or .yaml in /config subdirectory or in current directory
   * Inside Jar application-{profile}.properties or .yaml in /config package on classpath or in classpath root package

2. Application specific:
    * Outside Jar  application.properties or .yaml in /config subdirectory or in current directory
    * Inside Jar application.properties or .yaml in /config package on classpath or in classpath root package


Order:
Outside jar in /config path for profile specific properties file > in current directory > non profile files in same order >
/config path in class path for profile specific > i current root class path > for non profile files


* We can change the config file name using: spring.config.name
* We can also change the location pointed by spring using: spring.config.location