Embedded containers supported in spring boot:

* tomcat (default) with spring-boot-starter-web
* jetty
* undertow


* By default, spring boot provides tomcat as embedded container when spring-boot-starter-web dependency is added.
* We can change this my modifying in pom.xml
  * Exclude **spring-boot-starter-tomcat** dependency from **spring-boot-starter-web**
  * Include **spring-boot-starter-jetty** or **spring-boot-starter-undertow** dependency


---
* Fat jar - Also known as executable jars it contains compiled code and dependencies. It uses nested jars as dependencies
* Uber jar - Contains compiled code and all the dependencies are packed into single jar, can cause conflict with same filename

* To create Fat jar in spring boot, we need to use spring-boot-maven-plugin
* Fat jar creates MANIFEST.MF file which contains Main-class, Source-class and JarLauncher codes
* Original jar doesnt contain all the dependencies and is not executable


---
* WAR - Web Application Archive is a file represents web module, It cannot be executed standalone, it needs to be deployed in application server.
* Embedded Containers are used to execute executable jars. Embedded containers are packed as dependency in executable jars.It can run single application


* In spring boot default packaging is jar with spring-boot-maven-plugin, we can change it by modifying pom.xml >> packaging
* Use WAR plugin in plugins explicitly : maven-war-plugin