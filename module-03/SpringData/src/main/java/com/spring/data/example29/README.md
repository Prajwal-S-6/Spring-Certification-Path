**@Query**

* @Query annotation is used on top of finder methods in the Repository/Dao interfaces, with it we can specify the query that has to be used by Spring JPA
* Query mentioned on top of finder methods will be used instead of the autogenerated one by Spring JPA using based on method names(finder method naming convention)
* This gives more control over the query that will be executed

Eg: @Query("select e from employee e where e.lastName = ?2 and e.firstName = ?1")
    Employee findByFirstNameAndLastName(String firstName, String lastName);