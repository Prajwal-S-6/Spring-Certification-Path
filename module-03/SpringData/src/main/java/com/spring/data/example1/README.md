* Checked Exceptions: 
* Exception class which extends java.lang.Exception except RuntimeException.
* These exceptions have to be explicitly declared in the throws part of the method signature
* Other methods which invokes this have to handle these exceptions or it has to declare in the throws part of method signature
* Adv: Compile time feedback about the errors and if handled. And get the list of exceptions situation to be handled.
* Dis: Cluttered code, Coupling between caller and callee.