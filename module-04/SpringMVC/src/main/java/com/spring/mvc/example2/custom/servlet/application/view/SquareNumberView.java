package com.spring.mvc.example2.custom.servlet.application.view;

import com.spring.mvc.example2.custom.servlet.framework.model.Model;
import com.spring.mvc.example2.custom.servlet.framework.view.View;

public class SquareNumberView implements View {
    @Override
    public String render(Model model) {
        return String.format(
                "Square number of [%s] is [%s]",
                model.get("number"), model.get("numberSquare")
        );
    }
}
