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

---
With method security annotations before method is executed user is authorized to check if he has the required roles/authorities

* With @RolesAllowed and @Secured we can specify only the list of roles to be matched
* With @RolesAllowed("ADMIN") we just specify the role name without prefix
* With @Secured("ROLE_ADMIN") we need to prefix the rolename with ROLE_
