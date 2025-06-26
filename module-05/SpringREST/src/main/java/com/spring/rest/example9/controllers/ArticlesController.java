package com.spring.rest.example9.controllers;

import com.spring.rest.example9.dao.ArticlesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticlesController {
    @Autowired
    private ArticlesDao articlesDao;

    @GetMapping("/articles")
    public ModelAndView articles() {
       return new ModelAndView("index9",
               "articles", articlesDao.findAll());
    }
}
