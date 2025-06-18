package com.spring.mvc.example1.controller;

import com.spring.mvc.example1.dao.ArticleDao;
import com.spring.mvc.example1.ds.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class IndexController {

    @Autowired
    private ArticleDao articleDao;

    @GetMapping
    public String getArticles(Model model) {
        model.addAttribute("articles", articleDao.findAll());
        model.addAttribute("newArticle", new Article());
        return "index";
    }
}
