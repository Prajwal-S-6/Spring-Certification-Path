package com.spring.rest.example8.controllers;

import com.spring.rest.example8.dao.ArticlesDao;
import com.spring.rest.example8.ds.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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


}
