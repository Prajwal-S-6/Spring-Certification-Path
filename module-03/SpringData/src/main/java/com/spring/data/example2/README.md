* DataSource: Is a generic interface javax.sql.DataSource which represents data source for sql databases.
* Types of javax.sql.DataSource:
  * DriverManagerDataSource
  * BasicDataSource
  * ComboPooledDataSource
  * SmartDataSource
  * AbstractDataSource
  * SingleConnectionDataSource
  * TransactionAwareDataSource
  * DataSourceTransactionManager
  
* Configuring datasource is based on type of application
1. Standalone application: DataSource is configured in @Configuration and is created as a bean of one of the supported types
2. SpringBoot application: DataSource is configured in application.properties with spring.datasource.url, spring.datasource.driver-class-name
3. Application server: DataSource is configured using JndiDataSourceLookUp, is created as a bean. Application server is responsible for creating and managing datasource requested in resources configuration of deployment descriptors

* EmbeddedDatabaseBuilder allows to easily configure H2/HSQL embedded DB with schema and initialization script
* DataSourceInitializer, ResourceDataBasePopulator allows to use schema and initialization scripts without usage of EmbeddedDatabaseBuilder