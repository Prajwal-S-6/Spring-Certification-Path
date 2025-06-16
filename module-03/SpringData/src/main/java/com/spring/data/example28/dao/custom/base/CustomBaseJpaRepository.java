package com.spring.data.example28.dao.custom.base;

import com.spring.data.example28.ds.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.io.Serializable;

public class CustomBaseJpaRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> {

    private final EntityManager entityManager;

    public CustomBaseJpaRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public Employee findByFirstNameAndLastName(String firstName, String lastName) {
        System.out.println("Starting custom implementation of findByFirstNameAndLastName from CustomBaseJpaRepository - global level...");

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);
        criteria.where(
                criteriaBuilder.and(
                        criteriaBuilder.equal(employeeRoot.get("lastName"), lastName),
                        criteriaBuilder.equal(employeeRoot.get("firstName"), firstName)
                )
        );

        return entityManager.createQuery(criteria).getSingleResult();
    }
}
