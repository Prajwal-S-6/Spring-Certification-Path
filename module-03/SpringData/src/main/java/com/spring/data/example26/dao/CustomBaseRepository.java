package com.spring.data.example26.dao;

import org.springframework.data.repository.CrudRepository;

public interface CustomBaseRepository<T, ID> extends CrudRepository<T, ID> {
}
