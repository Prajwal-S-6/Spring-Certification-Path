package com.spring.boot.dao;

import com.spring.boot.ds.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemDao extends JpaRepository<TodoItem, Integer> {
}
