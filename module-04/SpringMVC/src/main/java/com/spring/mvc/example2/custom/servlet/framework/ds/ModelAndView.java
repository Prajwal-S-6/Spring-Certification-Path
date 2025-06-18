package com.spring.mvc.example2.custom.servlet.framework.ds;

import com.spring.mvc.example2.custom.servlet.framework.model.Model;
import com.spring.mvc.example2.custom.servlet.framework.view.View;

public class ModelAndView {

    private Model model;
    private View view;

    public ModelAndView(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }
}
