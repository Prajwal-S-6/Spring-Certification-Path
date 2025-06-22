Annotations that can be used on Controller method arguments

* @RequestParameter - provides access to the web request param, parameter will be automatically converted to declared method argument type\
                        required, Java 8 Optional<>, defaultValue

* @PathVariable - provides access to the URI template variable\
                    required, Java8 Optional<>

* @MatrixVariable - provides access to the name-value pair from the URI segments\
                    eg: /actionA/name=Praj;country=IN\
                    required, Optional<>