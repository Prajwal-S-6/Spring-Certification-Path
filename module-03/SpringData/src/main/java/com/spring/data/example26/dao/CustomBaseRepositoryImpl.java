package com.spring.data.example26.dao;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class CustomBaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements CustomBaseRepository<T, ID> {
    public CustomBaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
    }
}
