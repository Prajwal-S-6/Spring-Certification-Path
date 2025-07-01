* SpringSecurity is a cross-cutting concern
* Cross-cutting concern means functionality that is available throughout the application and affects multiple parts of the application, but is not closely associated with any business logic


* Security in Spring can be configured at 2 levels:
  * Web level - based on Servlet filters
  * Method Security level - based on Spring AOP
  

* Authentication
  * AuthenticationManager
  * ProviderManager
  * AuthenticationProviders
  * UserDetailsService
  
* Authorization
  * AccessDecisionManager
  * AccessDecisionVoters
  * AfterInvocationManager
  * Authorities
  

* At Web level it uses DelegatingFilterProxy and FilterChainProxy with list of filters to authenticate user
* At method security level - it proxies the invocation made, advices are applied to ensure security rules are followed to allow invocation
  * @EnableMethodSecurity
    * prePostEnabled - @PreAuthorize, @PostAuthorize
    * securedEnabled - @Secured
    * JSR 250 annotations - @PermitAll, @DenyAll, @RolesAllowed


---
Objects in Spring Security
* SecurityContextHolder
* SecurityContext
* Authentication
* GrantedAuthority
* AuthenticationManager
* ProviderManager
* AuthenticationProviders
* UserDetailsService
* SecurityInterceptor
* AccessDecisionManager
* AccessDecisionVoters
* AfterInvocationManager