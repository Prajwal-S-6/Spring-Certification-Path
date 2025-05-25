* Spring Profile

1. Is configured by saying which bean belongs to which profile
    * @Profile can be added on bean/class level with @Component, saying this bean belongs to this profile/profiles
    * @Profile can be added on @Configuration, saying all the beans configured there will belong to that profile/s
    * @Profile can be added on @Bean, saying the bean instance returned by that method belongs to that profile
    * Creating custom profile using @Profile annotation
2. And activating that profile
    * Profile can be activated programmatically - context.getEnvironment().



* Bean without any profile set will be part of all the profiles, unless excluded from any profile.