**Repository interface**
* It is a java interface where we can declare the Dao behaviors
* Based on which Spring data JPA will automatically provide the actual implementation for the Dao behaviors
* Example Spring data JPA will provide actual implementation to methods like - save, findAll, findById


* Repository interface takes Domain class(@Entity class) and type of @Id field to manage
* We can define our custom Repository interface by extending atleast one of these base interfaces:
  * Repository<D, ID> - basic marker repository interface
  * CrudRepository<D, ID>
  * PagingAndSortingRepository<D, ID>
  * JpaRepository<D, ID>


* We can declare the custom Dao behavior, and spring data jpa will provide implementation to those automatically
* Example - findSalaryBetween(float min, float max), findByEmail..

* In Spring we have to add @EnableJpaRepositories(basePackages = ) to tell spring which all packages to scan for the Dao repositories interface