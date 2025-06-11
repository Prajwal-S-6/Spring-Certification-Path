package com.spring.data.example14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class EmployeeService {

    @Autowired
    @Qualifier("custom_data_source")
    private DataSource dataSource;

    @Transactional
    public void declarativeTransaction() {
        // business logic
    }

    public void manualTransaction() throws SQLException {
        Connection connection = dataSource.getConnection();

        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

        try {
            // business logic

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.close();
        }
    }
}
