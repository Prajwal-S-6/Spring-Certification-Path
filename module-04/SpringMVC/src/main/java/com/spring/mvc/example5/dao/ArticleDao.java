package com.spring.mvc.example5.dao;

import com.spring.mvc.example5.ds.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleDao extends JpaRepository<Article, Integer> {

    List<Article> findByBodyLikeIgnoreCase(String content);
}
