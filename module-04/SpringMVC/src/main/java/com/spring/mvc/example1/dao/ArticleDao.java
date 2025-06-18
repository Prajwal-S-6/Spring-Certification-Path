package com.spring.mvc.example1.dao;

import com.spring.mvc.example1.ds.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<Article, Integer> {
}
