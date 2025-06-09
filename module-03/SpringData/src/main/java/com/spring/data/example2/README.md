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
