package com.certification.spring.beans.scopes.web.controllers;

import com.certification.spring.beans.scopes.web.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {

    @Autowired
    private SpringBean1 springBean1;

    @Autowired
    private SpringBean2 springBean2;

    @Autowired
    private SpringBean3 springBean3;

    @Autowired
    private SpringBean4 springBean4;

    @Autowired
    private SpringBean5 springBean5;

//    public SpringController(SpringBean1 springBean1, SpringBean2 springBean2, SpringBean3 springBean3, SpringBean4 springBean4, SpringBean5 springBean5) {
//        this.springBean1 = springBean1;
//        this.springBean2 = springBean2;
//        this.springBean3 = springBean3;
//        this.springBean4 = springBean4;
//        this.springBean5 = springBean5;
//    }

    @RequestMapping("/controller")
    @ResponseBody
    public String index() {
        return "<pre>" +
                springBean1 + " - Singleton\n" +
                springBean2 + " - Prototype\n" +
                springBean3 + " - Request Scope\n" +
                springBean4 + " - Session Scope\n" +
                springBean5 + " - Application Scope\n" +
                "</pre>";
    }
}
