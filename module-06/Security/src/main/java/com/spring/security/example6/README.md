Password Hashing

* SpringSecurity supports password hashing through password encoder interface
* Some of the PasswordEncoders are: bcrypt, scrypt, pbkdf2, argon2, sha256

*  Password encoder contains following methods:
  * encode() - to encode given password
  * matches - to match the given password by encoding it first and then comparing

* While login the DaoAuthenticationProvider will fetch the hashvalue from db and PasswordEncoder will encode the given password  and compare the hashValue
* DelegatingPasswordEncoder will use the prefix to delegate the password to the encoder while verifying
  * eg: {bcrypt}10ASDSDADJccxvc2342/GJHGjbbddf


---
**PasswordSalting**

* Is a process where before hashValue of the password is computed a sequence of random bytes are added to the plain password text and then encoded, this way same hashvalue will not be stored for same password
* When verifying password, the salt that is stored along with hashValue is added to the password and DelegatingPasswordEncoder will delegate to the appropriate passwordEncoder based on the prefix and encoded and compared