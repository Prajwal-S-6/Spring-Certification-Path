package com.spring.rest.example8.dao;

import com.spring.rest.example8.ds.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesDao extends JpaRepository<Article, Integer> {
}
