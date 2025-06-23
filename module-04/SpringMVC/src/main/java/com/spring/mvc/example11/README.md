ReturnType of @Controller methods

* @ResponseBody - binds the method return value to web response body, Complex type will be converted using HttpMessageConverter
* HttpEntity<>, ResponseEntity<> - allows to return full response body along with headers, ResponseEntity also allows to specify HttpStatus code
* HttpHeaders - returns only http headers without body
* String - to return the logical name of view, used when rendering response. view will be resolved using ViewResolver. Used with @ModelAttribute or Model to set the attributes in the view
* View - returns the instance of view like JSTLView, ThymeLeafView etc. Used with @ModelAttribute, Model for mapping of attributes to the view
* Model, Map - used to specify the attributes in the model. View name will be automatically resolved using **RequestToViewNameTranslator**
* @ModelAttribute - used on top of method, used to specify attributes to be added o the model. View name will be auo resolved by **RequestToViewNameTranslator**
* ModelAndView - to specify view and model attributes, also can specify response status. View can be specified as logical view name or view instance. Model can be model object or Map