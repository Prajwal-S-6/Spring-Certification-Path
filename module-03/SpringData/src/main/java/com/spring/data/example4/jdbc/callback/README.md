JDBC Template callback
* RowMapper - interface for processing ResultSet data on per row basis. Implementation should call ResultSet.get*(..), but should not call ResultSet.next().
                It should extract values from current row and based on those values should create object, which will be returned from mapRow method. Implementation is usually stateless
* RowCallbackHandler - interface for processing ResultSet on per row basis. Implementation should call ResultSet.getInt("employee_id"), ResultSet.getString("employee_name")
                Should not call ResultSet.next().\
                Difference between RowMapper and RowCallbackHandler is RowCallbackHandler doesnt return anything. Implementation is stateful as it doesnt return anything.
                processRow method from this doesnt return any value, hence the result needs to be stored into some Stateful object