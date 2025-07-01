**Authentication and Authorization**

* Authentication  - Is a process of verifying that user,system is who they claim to be. It means validation of submitted proof of identity is legit.
* This involves user sending identity and credentials to the application and application verifies it and accepts or rejects
* Authentication can be in simple form level, or CAS(Central Authentication Service) or MFA


* SpringSecurity provides support of Authentication:
  * Username and Password Authentication - FormLogin, Basic Authentication, Digest Authentication
  * Remember me authentication
  * OAuth 2.0
  * SAML2
  * CAS - SSO
  * OpenID support
  
* Storage for user name and password:
  * simple storage with in-memory authentication
  * Relational DB with JDBC authentication
  * LDAP storage with LDAP authentication
  * Custom data store with UserDetailsService
  
* Password Encoders: sha256, scrypt, bcrypt ...


---
* Authorization - Is a process of determining whether an authenticated user is allowed to access a particular resource or perform some action.
* Authorization uses Access Control List to determine what is allowed and disallowed.

* In SpringSecurity authorization can be implemented at 2 levels:
  * Web level - using mvcMatchers("/*/").hasRole(ROLE_ADMIN)
  * Method Security level using:
    * @EnableGlobalMethodSecurity
    * @Secured
    * @PreAuthorize
    * JSR 250 annotations @RolesAllowed, @PermitAll, @DenyAll


* AccessControlRules:
  * Roles: Represents highest privilege, used with hasRole()
  * Eg ROLE_ADMIN, ROLE_USER
  * Authority - READ_CUSTOMER, DELETE_EMPLOYEE used with hasAuthority
  * Hierarchical roles - Specifies relation between roles
  * Eg: ROLE_ADMIN > ROLE_USER means ROLE_ADMIN includes ROLE_USER