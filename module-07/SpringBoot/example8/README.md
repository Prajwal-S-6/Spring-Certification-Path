To configure external db in spring boot, configure following properties:
*Define dependency based on the db
* spring.datasource.url
* spring.datasource.username
* spring.datasource.password


To initialize db during application startup using schema.sql, data.sql we need to use in case of external db, for in-memory db not needed
* spring.datasource.initialization.mode=always