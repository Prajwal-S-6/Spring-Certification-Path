package com.spring.rest.example9.controllers;


import com.spring.rest.example9.dao.ArticlesDao;
import com.spring.rest.example9.ds.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ArticlesController {
    @Autowired
    private ArticlesDao articlesDao;

    @GetMapping("/articles")
    public ModelAndView articles() {
       return new ModelAndView("index9",
               "articles", articlesDao.findAll());
    }


    @GetMapping("/articlesResponseBody")
    @ResponseBody
    public List<Article> articleListResponseBody() {
        return articlesDao.findAll();
    }

    @GetMapping("/articlesNoResponseBody")
    public List<Article> articleListNoResponseBody() {
        return articlesDao.findAll();
    }
}
