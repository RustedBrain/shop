package com.rustedbrain.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rustedbrain.util.TestEntitys;
import org.hibernate.SessionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "AppServlet",
        description = "This is main app servlet",
        urlPatterns = "/AppServlet"
)
public class AppController extends HttpServlet {

    private ObjectMapper mapper;
    private ServletContext context;
    private SessionFactory factory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.mapper = new ObjectMapper();
        this.context = config.getServletContext();
        //this.factory = HibernateUtil.getSessionFactory();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ControllerAction action = ControllerAction.valueOf(req.getParameter("action").trim());
        RequestDispatcher requestDispatcher;

        switch (action) {
            case getAll: {
                req.setAttribute("all", TestEntitys.getEarings());
                requestDispatcher = req.getRequestDispatcher("/products.jsp");
            }
            break;
            case getEarings: {
                req.setAttribute("earings", TestEntitys.getEarings());
                requestDispatcher = req.getRequestDispatcher("/earings.jsp");
            }
            break;
            case getWatches: {
                req.setAttribute("watches", TestEntitys.getWatches());
                requestDispatcher = req.getRequestDispatcher("/watches.jsp");
            }
            break;
            case getBraslets: {
                req.setAttribute("braslets", TestEntitys.getEarings());
                requestDispatcher = req.getRequestDispatcher("/braslets.jsp");
            }
            break;
            case getBreloques: {
                req.setAttribute("breloques", TestEntitys.getWatches());
                requestDispatcher = req.getRequestDispatcher("/breloques.jsp");
            }
            break;
            default:{
                requestDispatcher = req.getRequestDispatcher("/error.jsp");
            }
        }

        requestDispatcher.forward(req, resp);
    }
}
