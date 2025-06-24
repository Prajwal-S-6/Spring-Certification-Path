REST - Representational State Transfer

* It is a architectural design style for designing distributed system, in which requesting systems access and modifies the web resources by using uniform and predefined set of stateless operations, given set of constraints
* Web resources are made available through URIs, and are accessed and modified through HTTP operations like - GET, PUT POST, DELETE ...
* Most RESTful services are using HTTP as protocol and JSON as form of data that moves between client and server, but it is not only tied to HTP and JSON

* REST provides:
  * Client-Server architecture
  * Statelessness
  * Cache ability

* Schematics:
    Http method + URI verb + noun  -> GET /customers/1

* Http methods used with REST services
  * GET - fetches resources or collection of resources at specified URI
  * PUT - creates new resource or update existing resource at specified URI
  * PATCH - updates part of the existing resource at specified URI
  * POST - creates new resource at specified URI or trigger some operation at the server
  * DELETE - deletes resource at the specified URI
  
* Other Http methods are: HEAD, OPTIONS, CONNECT, TRACE


---
* In case of error during processing of request.REST service should respond with:
  * HTTP status code
  * Code ID
  * Clear error message that explains the error
  

Http Status Code
  
* 1xx - Informational

* 2xx - Success
  * 200 - OK
  * 201 - Created
  * 203 - No Content
  
* 3xx - Redirection

* 4xx - Client Error
  * 400 - Bad Request
  * 401 - Unauthorized
  * 403 - Forbidden
  * 404 - Resource Not found
  
* 5xx - Server Error
  * 500 - Internal server error
  * 501 - Not implemented