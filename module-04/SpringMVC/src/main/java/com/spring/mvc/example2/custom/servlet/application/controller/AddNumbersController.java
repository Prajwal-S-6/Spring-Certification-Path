package com.spring.mvc.example2.custom.servlet.application.controller;

import com.spring.mvc.example2.custom.servlet.application.view.AddNumbersView;
import com.spring.mvc.example2.custom.servlet.framework.controller.CustomController;
import com.spring.mvc.example2.custom.servlet.framework.controller.IController;
import com.spring.mvc.example2.custom.servlet.framework.ds.ModelAndView;
import com.spring.mvc.example2.custom.servlet.framework.model.SimpleModel;
import jakarta.servlet.http.HttpServletRequest;

@CustomController("/mvc")
public class AddNumbersController implements IController {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {
        return new ModelAndView(
                new SimpleModel(),
                new AddNumbersView()
        );
    }
}
