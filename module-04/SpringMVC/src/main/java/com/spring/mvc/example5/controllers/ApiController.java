package com.spring.mvc.example5.controllers;

import com.spring.mvc.example5.dao.ArticleDao;
import com.spring.mvc.example5.ds.Article;
import com.spring.mvc.example5.ds.ArticleCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/api/articles", produces = "application/json")
public class ApiController {

    @Autowired
    private ArticleDao articleDao;

    @GetMapping
    public ResponseEntity<Iterable<Article>> getListOfArticles() {
        return ResponseEntity.ok().body(articleDao.findAll());
    }

    @RequestMapping(method = RequestMethod.HEAD)
    public ResponseEntity<Iterable<Article>> getArticlesCount() {
        return ResponseEntity.ok().header("Articles-Count", String.valueOf(articleDao.count()))
                .body(articleDao.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable int id) {
        return articleDao.findById(id)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "search", consumes = "application/json")
    public ResponseEntity<List<Article>> searchByCriteria(@RequestBody ArticleCriteria articleCriteria) {
        return ResponseEntity.ok().body(articleDao.findByBodyLikeIgnoreCase(articleCriteria.getBodyLike()));
    }

    @PutMapping
    public ResponseEntity<HttpStatus> addArticle(@RequestBody Article article) {
        articleDao.save(article);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable int id, @RequestBody Article article) {
        if(articleDao.existsById(id)) {
            article.setId(id);
            articleDao.save(article);

            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteArticle(@RequestParam("id") int id) {
        if(articleDao.existsById(id)) {
            articleDao.deleteById(id);

            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
