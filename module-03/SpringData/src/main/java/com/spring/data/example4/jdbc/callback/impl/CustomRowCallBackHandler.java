package com.spring.data.example4.jdbc.callback.impl;

import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomRowCallBackHandler implements RowCallbackHandler {
    private float salarySum;
    private int salariesCount;

    @Override
    public void processRow(ResultSet rs) throws SQLException {
        salarySum += rs.getFloat("salary");
        ++salariesCount;
    }

    public float getAverageSalary() {
        return (float) salarySum/salariesCount;
    }
}
