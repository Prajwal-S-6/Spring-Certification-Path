**DelegatingFilterProxy**

* Is a Spring framework internal class in spring-web module, which acts as a roxy between servlet filter and spring managed bean that implements ServletFilter
* DelegatingFilterProxy is registered within Application container and delegates all the calls to beans registered within application context
* It delegates all the calls to bean in application context based on Filter name provided in FilterConfiguration 
* Usually the filter name is springSecurityFilterChain and is of instance FilterChainProxy


* DelegatingFilterProxy can be registered in one of the following ways based on application type:
* Servlet2 - using web.xml
* Servlet3 - using AbstractSecurityWebApplicationInitializer >> insertSpringSecurityFilterChain will register DelegatingFilterProxy
* SpringBoot - using specialized version of DelegatingFilterPRoxy called DelegatingFilterProxyRegistrationBean registered by SecurityAutoConfiguration


* DelegatingFilterProxy delegates all the calls to FilterChainProxy based on the filter-name(springSecurityFilterChain)
* FilterChainProxy contains list of SecurityFilterChains which handles authentication and authorization


---
**SecurityFilterChain**

* SecurityFilterChain is a collection of spring managed filters called SecurityFilters which is responsible for authentication and authorization
* SecurityFilterChain is an interface in spring-web module. It provides list of filters associated to the request URL
* Spring provides default implementation called DefaultSecurityFilterChain which uses request matchers to match the list of filters associated to the request URL
* Some of he request matchers are
  * MvcRequestMatchers
  * AntPathRequestMatchers
  * RequestHeaderRequestMatchers
  * MediaTypeRequestMatchers etc

* Security Filters are implementation of Servlet filters managed by Spring context
