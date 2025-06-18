package com.spring.mvc.example1.controller;

import com.spring.mvc.example1.dao.ArticleDao;
import com.spring.mvc.example1.ds.Article;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mvc")
public class IndexController {

    @Autowired
    private ArticleDao articleDao;

    @GetMapping
    public String getArticles(Model model) {
        model.addAttribute("articles", articleDao.findAll());
        model.addAttribute("newArticleForm", new Article());
        return "index";
    }

    @PostMapping("/save-article")
    public String addArticle(@ModelAttribute Article article) {
        articleDao.save(article);
        return "redirect:/mvc";
    }

    @PostMapping("/delete-article")
    public String deleteArticle(@PathParam("id") int id) {
        articleDao.deleteById(id);
        return "redirect:/mvc";
    }
}
