Enabling JPA in Spring
* Add maven dependencies of spring-jpa, spring-orm, hibernate-orm(ORM of our choice), database driver of our choice, and additionally spring-data-jpa dependency.
* Define DataSource bean
* Define PlatformTransactionManager bean
* Define EntityManagerFactory - LocalContainerEntityManagerFactoryBean, EntityManagerFactory, LocalEntityManagerFactory
* Define @Entity class with atleast one @Id field
* Define Dao class with behaviours or Create interface by extending Repositories( eg. CrudRepository) which provides Dao behaviours automatically

---
Enabling JPA in SpringBoot
* In spring boot we just need to add spring-boot-starter-data-jpa dependency, which includes all the required dependencies
* Spring boot provides auto configuration for JPA
* We define data source in the application.properties/yaml file - spring.datasource.url, spring.datasource.driver-class-name
* It automatically provides EntityManager and transaction manager beans
* Provides out of box support for Hikari connection pool
* Automatically creates Dao beans for Repositories, no need to mention packages to scan for Dao(@EnableJpaRepositories)