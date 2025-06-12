package com.spring.data.example21.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<EmployeeDao, Integer> {
}
