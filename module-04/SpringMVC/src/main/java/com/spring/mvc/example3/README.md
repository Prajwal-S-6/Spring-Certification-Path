**WebApplicationContext**

* Is a Spring Application Context for web applications that runs under application server
* It supports servlet API and acts as a servlet container
* It is described by WebApplicationContext interface it also allows us to access ServletContext interface from servlet API


Scopes offered by WebApplicationContext:
1. @RequestScope - new bean instance per every http request
2. @SessionScope - new bean instance per every http session
3. @ApplicationScope - one bean instance per entire web application - ServletContext
4. @Scope(scopeName = "websocket") - bean lifecycle is coupled with websocket session, however bean lives longer than websocket session


* The difference between @ApplicationScope and @Scope(Singleton) is @ApplicationScope is singleton per servlet context not per SpringApplicationContext.
* Note a web application can have more than one SpringApplicationContext(not common)