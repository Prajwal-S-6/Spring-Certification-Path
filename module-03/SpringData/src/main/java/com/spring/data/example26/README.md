Defining Repository interface in Spring

* Create a interface which extends one these base repository interfaces(this represents Dao): Repository, CrudRepository, PagingAndSortingRepository, JpaRepository
* Create a @Entity class with atleast one @Id field which defines a primary key.
* In case of complex key create a class which represents complex key with @Embeddable annotation and use that class type as key in @Entity class with @EmbeddedId annotation at field level
* In Spring use @EnableJpaRepository(basePackages=) , to tell spring which packages to scan for Dao repositories.


* BTS spring uses JDKDynamicProxy to intercept all the calls to the repository interface or interfaces which extends base repository interface
* We can create custom base repository for every Dao by extending SimpleJpaRepository and configuring the same in
    @EnableJpaRepositories(basePackages = , repositoryBaseClass = )
* In spring boot also we can configure this by adding @EnableJpaRepositories(repositoryBaseClass = ) on top of @SpringBootApplication class