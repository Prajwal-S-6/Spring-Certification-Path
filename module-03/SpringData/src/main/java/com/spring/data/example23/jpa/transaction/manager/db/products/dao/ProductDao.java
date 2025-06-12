package com.spring.data.example23.jpa.transaction.manager.db.products.dao;

import com.spring.data.example23.jpa.transaction.manager.db.products.ds.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}
