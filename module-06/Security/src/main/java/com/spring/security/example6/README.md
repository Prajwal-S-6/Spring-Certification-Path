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


---
Example of how bcrypt will encode the password:

* Eg hashed password: $2a$10$4Hw.ix095n8Hs3pPf6E5UOfJk/ym9R0WY6u58OIt9pzRhZPV3F1DS
* $2a$ - represents the bcrypt algorithm
* 10 - represents the costfactor expressed as 2^10, how expensive it is to encode the given password, more costfactor = more difficult to bruteforce and more login processing time(cpu time)
* ix095n8Hs3pPf6E5UO - represents salt value
* Jk/ym9R0WY6u58OIt9pzRhZPV3F1DS - hashValue of the given password