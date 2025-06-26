package com.spring.rest.example8.controllers;

import com.spring.rest.example8.dao.ArticlesDao;
import com.spring.rest.example8.ds.Article;
import com.spring.rest.example8.ds.ArticleCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.MediaType.*;

@Controller
@RequestMapping("/articles")
public class ArticlesController {

    @Autowired
    private ArticlesDao articlesDao;

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Article>> listOfArticles() {
        return ResponseEntity.ok().body(articlesDao.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_XML_VALUE)
    public ResponseEntity<List<Article>> listOfArticlesXML() {
        return ResponseEntity.ok().body(articlesDao.findAll());
    }

    @RequestMapping(method = RequestMethod.HEAD, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Article>> articlesCount() {
        return ResponseEntity.ok()
                .header("Articles-Count", String.valueOf(articlesDao.count()))
                .body(articlesDao.findAll());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> getArticleById(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(articlesDao.findById(id).get());
    }

    @RequestMapping(path = "/search", produces = APPLICATION_JSON_VALUE, consumes = TEXT_PLAIN_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Article> findMatchingArticleBody(@RequestBody String value) {
        return ResponseEntity.ok().body(articlesDao.findByBodyLikeIgnoreCase(value));
    }

    @RequestMapping(path = "/search", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Article> findMatchingArticleBodyJSON(@RequestBody ArticleCriteria value) {
        return ResponseEntity.ok().body(articlesDao.findByBodyLikeIgnoreCase(value.getBodyLike()));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        return ResponseEntity.ok().body(articlesDao.save(article));
    }

    @RequestMapping(method = RequestMethod.PUT, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Article>> bulkUpdateArticles(@RequestBody List<Article> articles) {
        articlesDao.deleteAll();
        return  ResponseEntity.ok().body(articlesDao.saveAll(articles));
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PATCH, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> updateArticle(@PathVariable("id") int id, @RequestBody Article article) {
        if(articlesDao.existsById(id)) {
            article.setId(id);
            Article article1 = articlesDao.save(article);
            return ResponseEntity.ok().body(article1);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable int id) {
        if(articlesDao.existsById(id)) {
            articlesDao.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


}
