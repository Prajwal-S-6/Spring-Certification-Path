To configure external db in spring boot, configure following properties:
*Define dependency based on the db
* spring.datasource.url
* spring.datasource.username
* spring.datasource.password


To initialize db during application startup using schema.sql, data.sql we need to use in case of external db, for in-memory db not needed
* spring.sql.init.mode=always


---
* Spring boot uses schema.sql and data.sql to configure default schema and initial data.
* However, we can change these script file names by configuring in the properties:
  * spring.sql.init.schema-locations
  * spring.sql.init.data-locations


* Spring boot also loads different scripts based onn the platform defined:
  * spring.sql.init.platform=mysql
  * schema-${platform}.sql, data-${platform}.sql