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