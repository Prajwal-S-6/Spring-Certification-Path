package com.spring.mvc.example10.interceptor;

import com.spring.mvc.example10.ds.MutableCountHolder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

@Component
public class RequestTimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("processing-time", LocalDateTime.now());

        if (request.getSession().getAttribute("mutableCountHolder") == null)
            request.getSession().setAttribute("mutableCountHolder", new MutableCountHolder());

        return true;
    }
}
