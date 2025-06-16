package com.spring.data.example28.dao.custom.respository;

import com.spring.data.example28.ds.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomEmployeeFindRepositoryImpl implements CustomEmployeeFindRepository{

    @Autowired
    private EntityManager entityManager;


    @Override
    public Employee findByFirstNameAndLastName(String firstName, String lastName) {

        System.out.println("Starting custom implementation of findByFirstNameAndLastName - At single Dao/Repository level");
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.where(
                criteriaBuilder.and(
                        criteriaBuilder.equal(employeeRoot.get("firstName"), firstName),
                        criteriaBuilder.equal(employeeRoot.get("lastName"), lastName)
                )
        );

        return entityManager.createQuery(criteria).getSingleResult();
    }
}
