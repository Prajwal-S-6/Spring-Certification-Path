package com.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void printEmployeeEmails(){
        jdbcTemplate.queryForList("select email from employee", String.class).forEach(System.out::println);
    }
}
