* Calls to @Controller can be intercepted.
* Custom ExceptionHandling can be implemented using @ExceptionHandler and @ControllerAdvice
* @ExceptionHandler - when applied at controller method level, acts as exception handler for those exception only in that Controller
* @ControllerAdvice, @ExceptionHandler - acts as a global level exception handler for exception type thrown from any Controller class

* @ExceptionHandler - by default returns logical view name which renders the error details
* If we want the response to be serialized then use @ResponseBody along with @ExceptionHandler

* @RestControllerAdvice = @ControllerAdvice + @ResponseBody
* @RestControllerAdvice is used for REST APIs exceptionHandling
* @ControllerAdvice/@RestControllerAdvice can be used on top of Class for global exception handling
* @ExceptionHandler - used on top of method alone in Controller class methods or along with @ControllerAdvice for global level handling
