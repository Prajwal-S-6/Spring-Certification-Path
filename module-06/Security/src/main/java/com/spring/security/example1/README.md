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