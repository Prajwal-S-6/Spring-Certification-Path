package com.spring.data.example28.dao.custom.respository;

import com.spring.data.example28.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface CustomEmployeeDao extends CrudRepository<Employee, Integer>, CustomEmployeeFindRepository {
    Employee findByFirstNameAndLastName(String firstName, String lastName);
}
