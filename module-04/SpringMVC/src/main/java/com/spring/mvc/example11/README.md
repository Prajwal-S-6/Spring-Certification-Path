ReturnType of @Controller methods

* @ResponseBody - binds the method return value to web response body, Complex type will be converted using HttpMessageConverter
* HttpEntity<>, ResponseEntity<> - allows to return full response body along with headers, ResponseEntity also allows to specify HttpStatus code
* HttpHeaders - returns only http headers without body