Spring bean Instantiation
* All singleton beans are eagerly instantiated by default
* All prototype beans are lazily instantiated by default

Exception case: If singleton beans are dependent on prototype beans then these dependencies to be resolved hence,
                prototype beans are also eagerly instantiated

Ways of lazy loading beans
1. @ComponentScope(lazyInit = true) - will lazily load all the scanned components in the container,
    but we can explicitly make components as @Lazy(value=false) to eagerly load the beans
2. @Lazy - Classes/Beans annotated with @Lazy are lazily loaded