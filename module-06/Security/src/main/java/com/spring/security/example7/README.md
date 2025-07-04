**@EnableMethodSecurity**

* Method level security is needed to add additional security rules at the application service layer
* Weblevel security rules is based mainly on url pattern(request matchers)
* When we need more fine grained security rules to be applied we can use MethodSecurity


* To enable method level security we need to use
  * @EnableMethodSecurity annotation

* This supports method level security annotations like:
  * @Secured
  * @RolesAllowed
  * @PreAuthorize, @PostAuthorize, @PreFilter, @PostFilter


* These annotations work if
  * @EnableMethodSecurity(securedEnabled=true, prePostEnabled=true, jsr250Enabled=true)