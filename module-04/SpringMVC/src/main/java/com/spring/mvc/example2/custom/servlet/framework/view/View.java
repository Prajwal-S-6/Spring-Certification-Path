package com.spring.mvc.example2.custom.servlet.framework.view;

import com.spring.mvc.example2.custom.servlet.framework.model.Model;

public interface View {

    String render(Model model);
}
