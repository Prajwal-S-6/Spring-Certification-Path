**DelegatingFilterProxy**

* Is a Spring framework internal class, which acts as a roxy between servlet filter and spring managed bean that implements ServletFilter
* DelegatingFilterProxy is registered within Application container and delegates all the calls to beans registered within application context
* It delegates all the calls to bean in application context based on Filter name provided in FilterConfiguration 
* Usually the filter name is springSecurityFilterChain and is of instance FilterChainProxy


* DelegatingFilterProxy can be registered in one of the following ways based on application type:
* Servlet2 - using web.xml
* Servlet3 - using AbstractSecurityWebApplicationInitializer >> insertSpringSecurityFilterChain will register DelegatingFilterProxy
* SpringBoot - using specialized version of DelegatingFilterPRoxy called DelegatingFilterProxyRegistrationBean registered by SecurityAutoConfiguration
