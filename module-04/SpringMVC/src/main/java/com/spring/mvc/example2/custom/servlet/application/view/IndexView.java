package com.spring.mvc.example2.custom.servlet.application.view;

import com.spring.mvc.example2.custom.servlet.framework.model.Model;
import com.spring.mvc.example2.custom.servlet.framework.view.View;

public class IndexView implements View {
    @Override
    public String render(Model model) {
        return "Hello from Index Controller and View<br/>" +
                "Please visit one of following sites:<br/>" +
                "<ul>" +
                "<li><a href='/add-numbers?numberA=2&numberB=4'>/add-numbers?numberA=2&numberB=4</a></li>" +
                "<li><a href='/square-number?number=4'>/square-number?number=4</a></li>" +
                "</ul>";
    }
}
