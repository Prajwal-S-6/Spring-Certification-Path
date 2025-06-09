* Checked Exceptions: 
* Exception class which extends java.lang.Exception except RuntimeException.
* These exceptions have to be explicitly declared in the throws part of the method signature
* Other methods which invokes this have to handle these exceptions or it has to declare in the throws part of method signature
* Adv: Compile time feedback about the errors and if handled. And get the list of exceptions situation to be handled.
* Dis: Cluttered code, Coupling between caller and callee.


* Unchecked Exceptions:
* Exception class which extends java.lang.RuntimeException.
* These exceptions need not be explicitly added in the throws part of the method signature.
* Hence, the code which invokes this method doesn't have to handle these exceptions.
* We have the freedom of choice whether to handle exception or not.
* Adv: Less cluttered code, No coupling between caller and callee.
* Dis: Lack of compile time feedback, hence some errors handling might be missing

---
* Spring prefers Unchecked exceptions because of less coupling between caller and callee. And less cluttered code.
* Example: DataAccessException is a Runtime Exception(unchecked). To avoid coupling with concrete implementation of DataAccessException 
* Examples of concrete DataAccessException are: CannotAcquireLockException, CannotCreateRecordException, DataIntegrityViolationException