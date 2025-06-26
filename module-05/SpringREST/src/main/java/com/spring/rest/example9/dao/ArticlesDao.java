package com.spring.rest.example9.dao;

import com.spring.rest.example9.ds.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesDao extends JpaRepository<Article, Integer> {
}
