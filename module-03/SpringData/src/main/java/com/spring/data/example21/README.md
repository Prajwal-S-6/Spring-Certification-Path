**Spring JPA**

* To enable JPA in spring
  1. Add maven dependencies:
     * JPA API - javax.persistence-api
     * Spring ORM - org.springframework: spring-orm
     * ORM of our choice - org.hibernate: hibernate-core
     * Database driver - org.mysql
     * Additionally Spring data JPA - org.springframework.data: spring-data-jpa
  2. Define DataSource bean in @Configuration class
  3. Define PlatformTransactionManager bean in @Configuration --- JtaTransactionManager
  4. Define EntityManagerFactoryBean
     * LocalContainerEntityManagerFactoryBean - for standalone app
     * EntityManagerFactory - from JNDI
     * LocalEntityManagerFactoryBean - for tests
  5. Define atleast one @Entity class with atleast one @Id field
  6. Define Dao classes, or we can use SpringDataJPA by implementing CrudRepository