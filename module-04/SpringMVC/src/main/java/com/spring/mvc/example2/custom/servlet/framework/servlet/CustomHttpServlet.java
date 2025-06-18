package com.spring.mvc.example2.custom.servlet.framework.servlet;

import com.spring.mvc.example2.custom.servlet.framework.controller.IController;
import com.spring.mvc.example2.custom.servlet.framework.ds.ModelAndView;
import com.spring.mvc.example2.custom.servlet.framework.model.Model;
import com.spring.mvc.example2.custom.servlet.framework.utils.ControllersFinder;
import com.spring.mvc.example2.custom.servlet.framework.view.View;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "custom-servlet", urlPatterns = "/mvc/*")
public class CustomHttpServlet extends HttpServlet {

    private Map<String, IController> uriToControllerMap;

    @Override
    public void init() {
        uriToControllerMap = new ControllersFinder().findControllers();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestUri = req.getRequestURI();
        IController controller = uriToControllerMap.get(requestUri);

        if(controller != null) {
            ModelAndView modelAndView = controller.handleRequest(req);
            Model model = modelAndView.getModel();
            View view = modelAndView.getView();

            String renderedView = view.render(model);

            resp.setContentType("text/html");
            resp.getWriter().print(renderedView);
        } else {
            throw new ServletException("Unable to find the Controller for request uri " + requestUri);
        }
    }
}
