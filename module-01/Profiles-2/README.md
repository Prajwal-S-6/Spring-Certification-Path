* @Profile can be added on @Bean method, @Component - it means the bean instance returned from that method will be part of that profile only. Similarly the component class will be part of that profile
* All the other beans will be part of all the profiles, unless explicitly mentioned
* Bean will be created by spring only if the mentioned profile is active


* @Profile("database") - part of "database" profile only.
* @Profile({"database", "fileStore"}) - part of "database" and "fileStore" profiles
* @Profile("!dev") - not part of "dev" profile
