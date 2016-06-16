package com.rustedbrain.controller;

import com.rustedbrain.model.GuestSession;
import com.rustedbrain.util.database.HibernateUtil;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/AppServlet")
public class AppServlet extends HttpServlet {

    private Logger logger;

    @Override
    public void init() throws ServletException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        this.logger = Logger.getLogger(BucketServlet.class.getName());
        session.createCriteria(GuestSession.class).list().stream().forEach(session::delete);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MainAction action = MainAction.valueOf(req.getParameter("mainAction").trim());
        RequestDispatcher requestDispatcher;

        switch (action) {
            case getItems: {
                requestDispatcher = req.getRequestDispatcher("/ItemServlet");
            }
            break;
            case getBucket: {
                requestDispatcher = req.getRequestDispatcher("/BucketServlet");
            }
            break;
            default: {
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
