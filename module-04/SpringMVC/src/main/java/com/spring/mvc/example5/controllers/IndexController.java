package com.spring.mvc.example5.controllers;

import com.spring.mvc.example5.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private ArticleDao articleDao;

    @GetMapping({"/", "/index", "/home"})
    public String getIndex(Model model) {
        model.addAttribute("articles", articleDao.findAll());

        return "index5";
    }
}
