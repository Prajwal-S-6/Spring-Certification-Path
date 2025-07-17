Embedded containers supported in spring boot:

* tomcat (default) with spring-boot-starter-web
* jetty
* undertow


* By default, spring boot provides tomcat as embedded container when spring-boot-starter-web dependency is added.
* We can change this my modifying in pom.xml
  * Exclude **spring-boot-starter-tomcat** dependency from **spring-boot-starter-web**
  * Include **spring-boot-starter-jetty** or **spring-boot-starter-undertow** dependency