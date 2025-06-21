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
* RedirectAttributes - to set the attributes to use in case of redirects\
                        regular attributes will be kept as part of request param - accessed using @RequestParam\
                        flash attributes will be kept until end of request ie kept in session - will be available in the model view or can be accessed using @ModelAttribute
* Error, BindingResult - provides access to form validation and binding results\
                        can be used with @ModelAttribute, @RequestBody, @RequestPart\
                        Error and BindingResult method parameter have to be immediately after @Valid annotated parameter in method
* @SessionAttributes, SessionStatus - Allows to keep @ModelAttributes object between requests\
                                        SessionStatus allows to clear session variables once request is processed