package com.spring.data.example4.jdbc.callback.impl;

import com.spring.data.example4.jdbc.callback.ds.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomResultSetExtractor implements ResultSetExtractor<Float> {
    @Override
    public Float extractData(ResultSet rs) throws SQLException, DataAccessException {
        float salarySum = 0;
        int salariesCount = 0;

        while (rs.next()) {
            salarySum += rs.getFloat("salary");
            ++salariesCount;
        }

        return salarySum/salariesCount;
    }
}
