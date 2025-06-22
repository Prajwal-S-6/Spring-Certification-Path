Annotations that can be used on Controller method arguments

* @RequestParameter - provides access to the web request param, parameter will be automatically converted to declared method argument type\
                        required, Java 8 Optional<>, defaultValue

* @PathVariable - provides access to the URI template variable\
                    required, Java8 Optional<>

* @MatrixVariable - provides access to the name-value pair from the URI segments\
                    eg: /actionA/name=Praj;country=IN\
                    required, Optional<>

* @CookieValue - provides access to the session cookie value. Cookie can be set using HttpServletResponse and Cookie class\
                    required, Optional<>\
                    defaultValue

* @RequestHeader - provides access to the Http Request headers. When we bind against map then we get all headers key-value pairs\
                    required, Optional<>, defaultValue

* @RequestBody - provides access to the Http Request body, the request body will be converted to the method argument type automatically by HttpMessageConverter\
                    required, Optional<>, Can be used with @Valid

* @RequestPart - provides access to the http request multi parts\
                    required, Optional<>, Can be used with @Valid

* @RequestAttribute - provides access to the request attribute that is set before the request hits the controller method. These are set from server side using Filters or Interceptors\
                        required, Optional<>
