package com.spring.mvc.example3.controllers;

import com.spring.mvc.example3.beans.ApplicationScopeBean;
import com.spring.mvc.example3.beans.RequestScopeBean;
import com.spring.mvc.example3.beans.SessionScopeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("saveRequestScopeValue")
    public String saveRequestScopeValue(@RequestParam("requestScopeValue") int value) {
        requestScopeBean.setValue(value);
        return "forward:/mvc";
    }

    @PostMapping("saveSessionScopeValue")
    public String saveSessionScopeValue(@RequestParam("sessionScopeValue") int value) {
        sessionScopeBean.setValue(value);
        return "forward:/mvc";
    }

    @PostMapping("saveApplicationScopeValue")
    public String saveApplicationScopeValue(@RequestParam("applicationScopeValue") int value) {
        applicationScopeBean.setValue(value);
        return "forward:/mvc";
    }

}
