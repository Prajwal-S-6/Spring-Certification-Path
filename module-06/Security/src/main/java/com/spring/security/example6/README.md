Password Hashing

* SpringSecurity supports password hashing through password encoder interface
* Some of the PasswordEncoders are: bcrypt, scrypt, pbkdf2, argon2, sha256

*  Password encoder contains following methods:
  * encode() - to encode given password
  * matches - to match the given password by encoding it first and then comparing

* While login the DaoAuthenticationProvider will fetch the hashvalue from db and PasswordEncoder will encode the given password  and compare the hashValue
* DelegatingPasswordEnocder will use the prefix to delegate the password to the encoder while verifying
  * eg: {bcrypt}10ASDSDADJccxvc2342/GJHGjbbddf