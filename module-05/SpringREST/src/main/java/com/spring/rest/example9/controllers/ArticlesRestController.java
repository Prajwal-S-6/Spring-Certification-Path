package com.spring.rest.example9.controllers;

import com.spring.rest.example9.dao.ArticlesDao;
import com.spring.rest.example9.ds.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/api/articles")
public class ArticlesRestController {
    @Autowired
    private ArticlesDao articlesDao;

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Article>> listArticlesJSON() {
        return ResponseEntity.ok().body(articlesDao.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_XML_VALUE)
    public ResponseEntity<List<Article>> listArticlesXML() {
        return ResponseEntity.ok().body(articlesDao.findAll());
    }
}
