package com.spring.boot;

import com.spring.boot.dao.TodoItemDao;
import com.spring.boot.ds.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    private TodoItemDao todoItemDao;

    @GetMapping("/")
    public String items(Model model) {
        model.addAttribute("todoItems", todoItemDao.findAll());
        model.addAttribute("newTodoItem", new TodoItem());
        return "index";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute("newTodoItem") TodoItem todoItem) {
        todoItemDao.save(todoItem);

        return "redirect:/";
    }
}
