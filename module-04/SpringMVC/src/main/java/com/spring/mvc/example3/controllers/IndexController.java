package com.spring.mvc.example3.controllers;

import com.spring.mvc.example3.beans.ApplicationScopeBean;
import com.spring.mvc.example3.beans.RequestScopeBean;
import com.spring.mvc.example3.beans.SessionScopeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

@Controller
@RequestMapping("/mvc")
public class IndexController {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private RequestScopeBean requestScopeBean;
    @Autowired
    private SessionScopeBean sessionScopeBean;
    @Autowired
    private ApplicationScopeBean applicationScopeBean;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String getIndex(Model model) {
        model.addAttribute("servletContext", webApplicationContext.getServletContext());
        model.addAttribute("requestScopeValue", requestScopeBean.getValue());
        model.addAttribute("sessionScopeValue", sessionScopeBean.getValue());
        model.addAttribute("applicationScopeValue", applicationScopeBean.getValue());

        return "index3";
    }

}
