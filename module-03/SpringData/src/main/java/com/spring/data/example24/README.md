Enabling JPA in Spring
* Add maven dependencies of spring-jpa, spring-orm, hibernate-orm(ORM of our choice), database driver of our choice, and additionally spring-data-jpa dependency.
* Define DataSource bean
* Define PlatformTransactionManager bean
* Define EntityManagerFactory - LocalContainerEntityManagerFactoryBean, EntityManagerFactory, LocalEntityManagerFactory
* Define @Entity class with atleast one @Id field
* Define Dao class with behaviours or Create interface by extending Repositories( eg. CrudRepository) which provides Dao behaviours automatically
