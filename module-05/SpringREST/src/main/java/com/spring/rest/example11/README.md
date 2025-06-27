Http StatusCode for successful GET, POST, PUT, DELETE

* GET
  * 200 - OK - when existing resource is successfully returned
  
* POST
  * 201 - CREATED - when new resource is created
  * 200 - OK - when some processing is done on the request and resource was returned, but no new resource was created
  * 204 - NO_CONTENT - some processing was done, but no content was returned

* PUT
  * 201 - CREATED - when new resource is created
  * 200 - OK - when existing resource was update and the updated resource was returned
  * 204 - NO_CONTENT - when existing resource was updated, but no content was returned
  
* DELETE
  * 204 - NO_CONTENT - when resource was deleted successfully