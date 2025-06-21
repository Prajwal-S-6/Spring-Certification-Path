Method parameter types hat can be used on @Controller methods

* WebRequest, NativeWebRequest - Provides access to http request details, parameters, session attributes
* ServletRequest, ServletResponse - provides access to http request details and other attributes
* HttpSession - provides access to session information and enforces http session for request
* Principal - provides currently authenticated user
* HttpMethod - provides access to http methods like GET, PUSH, PUT ...
* Locale - provides request's locale
* TimeZone, ZoneId - provides timezone associated with Request
* InputStream, Reader - provides access to raw request body
* OutputStream, Writer - allows to create raw response
* HttpEntity - a container that provides access to request headers and body
* Map, Model, Model - to add data to templates as part of view rendering