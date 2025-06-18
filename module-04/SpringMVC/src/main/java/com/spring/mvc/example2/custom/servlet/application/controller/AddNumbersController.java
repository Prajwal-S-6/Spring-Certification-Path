package com.spring.mvc.example2.custom.servlet.application.controller;

import com.spring.mvc.example2.custom.servlet.application.view.AddNumbersView;
import com.spring.mvc.example2.custom.servlet.framework.controller.CustomController;
import com.spring.mvc.example2.custom.servlet.framework.controller.IController;
import com.spring.mvc.example2.custom.servlet.framework.ds.ModelAndView;
import com.spring.mvc.example2.custom.servlet.framework.model.Model;
import com.spring.mvc.example2.custom.servlet.framework.model.SimpleModel;
import jakarta.servlet.http.HttpServletRequest;

import static java.lang.String.valueOf;

@CustomController("/mvc")
public class AddNumbersController implements IController {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {
        Model model = new SimpleModel();

        int numberA = Integer.parseInt(request.getParameter("numberA"));
        int numberB = Integer.parseInt(request.getParameter("numberB"));

        model.set("numberA", valueOf(numberA));
        model.set("numberB", valueOf(numberB));
        model.set("result", valueOf(numberA + numberB));

        return new ModelAndView(
                model,
                new AddNumbersView()
        );
    }
}
