REST is stateless
* Statelessness is one of the basic principle of RESTful Architecture
* Each request from client should contain all the required information to process the request
* It should not depend on some state being used on server side
* If some kind of state is required for the request, then client should send that state along with the request.
* However, this state should not be kept at server side, for example in a session
* This will limit the system from being scalable as each reques depends on some state