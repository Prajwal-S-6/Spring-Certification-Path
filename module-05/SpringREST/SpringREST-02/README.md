**RestTemplate**

* Is a http client wrapper to perform http requests. It exposes API over underlying libraries like JDKUrlConnection etc
* It is a tool to call other APIs of other web services from our code
* It also helps in testing our endpoints by calling the making the request from our test
* It supports many operation like
  * Automatic Serialization and Deserialization of response
  * Automatic registration of HttpMessageConverters
  * HTTP GET for Objects
  * POST for Objects
  * PUT, PATCH for Objects, DELETE