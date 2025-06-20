package com.spring.mvc.example2.custom.servlet.application.view;

import com.spring.mvc.example2.custom.servlet.framework.model.Model;
import com.spring.mvc.example2.custom.servlet.framework.view.View;

public class AddNumbersView implements View {
    @Override
    public String render(Model model) {
        return String.format(
                "Result of adding numberA = [%s] and numberB = [%s] is [%s]",
                model.get("numberA"), model.get("numberB"), model.get("result")
        );
    }
}
