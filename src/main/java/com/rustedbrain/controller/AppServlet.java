package com.rustedbrain.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(
        description = "This is main app servlet",
        urlPatterns = "/AppServlet"
)
public class AppServlet extends HttpServlet {

    private ServletContext context;
    private Logger logger;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
        this.logger = Logger.getLogger(AppServlet.class.getName());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MainAction action = MainAction.valueOf(req.getParameter("mainAction").trim());
        RequestDispatcher requestDispatcher;

        switch (action) {
            case getItems: {
                this.logger.log(Level.INFO, action.name() + " is be carrying now");
                requestDispatcher = req.getRequestDispatcher("/ItemServlet");
            }
            break;
            case getBucket: {
                this.logger.log(Level.INFO,action.name() + " is be carrying now");
                requestDispatcher = req.getRequestDispatcher("/BucketServlet");
            }
            break;
            default: {
                this.logger.log(Level.INFO, action.name() + "is not defined");
                requestDispatcher = req.getRequestDispatcher("/error.jsp");
            }
        }

        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
