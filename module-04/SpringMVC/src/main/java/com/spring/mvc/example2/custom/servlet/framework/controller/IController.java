package com.spring.mvc.example2.custom.servlet.framework.controller;

import com.spring.mvc.example2.custom.servlet.framework.ds.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;


public interface IController {

    ModelAndView handleRequest(HttpServletRequest request);
}
