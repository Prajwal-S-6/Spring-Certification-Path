**@DataJpaTest**

* Is used on class level to write integration test for JPA related components like Entities, Repositories
* It autoconfigures embedded database we can disable embedded db using @AutoConfigureTestDatabase(replace="None")
* Scans and autoconfigures @Entity beans
* Scans and autoconfigures Spring data Repositories
* Configures TestEntityManager
* Doesnt load other Components like @Controller, @Service etc
* Every @DataJpaTest is transactional by default and after each test transaction is rolled back, we can stop rollback using @RolledBack(false)
