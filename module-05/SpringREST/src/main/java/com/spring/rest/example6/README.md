**HttpMessageConverter**

* Is an interface in Spring that is used to convert data between different formats
* REST client can specify the format in which they want using header - Accept: application/json
* REST client can also specify the format in which the data is being sent using header - Content-Type: application/xml


* Spring will keep the list of HttpMessageConverters and for each request the format requested are analyzed and the cross referenced with the methods implemented in Controllers
* When matching method is found, that method is picked and HttpMessageConverter performs the conversion
* @RequestMapping contains produces and consumes fields to indicate the MediaType which method can handle

---
HttpMessageConverter:
1. Converts the HttpInputMessage to required type
2. Converts Type into HttpOutputMessage

* It has the following methods:
  * canRead, canWrite, getSupportedMediaTypes, read, write

* CustomHttpMessageConverter can be created by implementing GenericHttpMessageConverter
* Customer HttpMessageConverter can be registered by implementing WebMvcConfigurer interface
* In Springboot most HttpMessageConverter are registered automatically using HttpMessageConverterAutoConfiguration, we just include required dependencies
* Default list of converters are created inside WebMvcConfigurationSupport.addDefaultHttpMessageConverters


* Commonly used:
  * MappingJackson2HttpMessageConverter
  * StringHttpMessageConverter
  * ByteArrayHttpMessageConverter