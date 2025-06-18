package com.spring.mvc.example2.custom.servlet.application.controller;

import com.spring.mvc.example2.custom.servlet.application.view.SquareNumberView;
import com.spring.mvc.example2.custom.servlet.framework.controller.CustomController;
import com.spring.mvc.example2.custom.servlet.framework.controller.IController;
import com.spring.mvc.example2.custom.servlet.framework.ds.ModelAndView;
import com.spring.mvc.example2.custom.servlet.framework.model.Model;
import com.spring.mvc.example2.custom.servlet.framework.model.SimpleModel;
import jakarta.servlet.http.HttpServletRequest;

import static java.lang.String.valueOf;

@CustomController("/mvc")
public class SquareNumberController implements IController {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {
        Model model =new SimpleModel();

        int number = Integer.parseInt(request.getParameter("number"));

        model.set("number", valueOf(number));
        model.set("numberSquare", valueOf(number * number));

        return new ModelAndView(
                model,
                new SquareNumberView()
        );
    }
}
