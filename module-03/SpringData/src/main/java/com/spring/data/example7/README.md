* JdbcTemplate supports generic queries using:
* queryForObject - returns single object, expects query to return single record with single or multiple columns
* queryForList - returns list of objects of declared type, expects query to return multiple records with one column only.
* queryForMap - returns map for a single row with key representing column_name, and value representing db record value. Expects query to return single record
* queryForRowSet - returns SQLRowSet object that contains metadata like column names, allows to read the result and iterate over the records.

* queryForObject uses SingleColumnRowMapper for generic type, for multiple columns it uses custom RowMapper
* queryForList uses SingleColumnRowMapper
* queryForMap uses ColumnMapRowMapper for any query