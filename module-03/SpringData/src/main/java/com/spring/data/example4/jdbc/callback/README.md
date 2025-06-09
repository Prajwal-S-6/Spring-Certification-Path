JDBC Template callback
* RowMapper - interface for processing ResultSet data on per row basis. Implementation should call ResultSet.get*(..), but should not call ResultSet.next().
                It should extract values from current row and based on those values should create object, which will be returned from mapRow method. Implementation is usually stateless
* RowCallbackHandler - interface for processing ResultSet on per row basis. Implementation should call ResultSet.getInt("employee_id"), ResultSet.getString("employee_name")
                Should not call ResultSet.next().\
                Difference between RowMapper and RowCallbackHandler is RowCallbackHandler doesnt return anything. Implementation is stateful as it doesnt return anything.
                processRow method from this doesnt return any value, hence the result needs to be stored into some Stateful object
* ResultSetExtractor - interface for processing entire resultset data, all rows needs to be processed and implementation should call ResultSet.next() to move between rows.
                        Closing of resultset is handled by jdbc template, so no need to close the resultset


* Some of the other jdbc template callback
  * PreparedStatementCreator - to create PreparedStatement based on the connection provided by JdbcTemplate, implementation should provide SQL and parameters
  * PreparedStatementSetter - to set the values on PreparedStatement, implementation should only set the parameters
  * CallableStatementCreator - to create callable statement based on connection provided by JdbcTemplate, implementation should provide SQL and parameters
  * PreparedStatementCallback and CallableStatementCallback - used internally by JdbcTemplate