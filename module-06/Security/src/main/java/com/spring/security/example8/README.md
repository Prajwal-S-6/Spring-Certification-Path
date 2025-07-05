Spring Security supports sPEL expressions with following annotations
* EnableMethodSecurity(prePostEnabled = true)


* @PreFilter - used to filter the collection based on Security rules before the method is executed
* @PreAuthorize - to determine whether method can be executed based on Security rules
* @PostAuthorize - to determine whether executed method value needs to be returned based on Security rules
* @PostFilter - to filter the collection based on security rules after method is executed from the returned value


* With @PreFilter/@PostFilter we use filterObject
* With @PostAuthorize, we use returnObject