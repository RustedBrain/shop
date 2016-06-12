package com.rustedbrain.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rustedbrain.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
        this.factory = HibernateUtil.getSessionFactory();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ControllerAction action = ControllerAction.valueOf(req.getParameter("action").trim());
        String targetId = req.getParameter("id");
        StringBuilder sb = new StringBuilder();

        Session session = factory.openSession();
//        switch (action) {
//            case LOGIN: {
//                User user = DatabaseUtil.getUser(req.getParameter("userName"), req.getParameter("userPassword"), session);
//                if (user != null)
//
//            }
//            default: {
//                context.getRequestDispatcher("/error.jsp").forward(req, resp);
//            }
//        }

        session.close();
    }



}
