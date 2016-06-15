package com.rustedbrain.controller;

import com.rustedbrain.model.Item;
import com.rustedbrain.util.TestEntitys;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(
        description = "Servlet that make all job with bucket",
        urlPatterns = "/BucketServlet"
)
public class BucketServlet extends HttpServlet {

    private ServletContext context;
    private Logger logger;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
        this.logger = Logger.getLogger(AppServlet.class.getName());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SubAction action = SubAction.valueOf(req.getParameter("subAction").trim());
        RequestDispatcher requestDispatcher;
        HttpSession httpSession = req.getSession();

        switch (action) {
            case addItem: {
                //Session session = HibernateUtil.getSessionFactory().openSession();
                this.logger.log(Level.INFO, "product from: " + req.getParameter("itemCategory") + " with id[" + req.getParameter("itemId") + "]");
                httpSession.setAttribute("products", TestEntitys.getEarings().get(1));
                requestDispatcher = req.getRequestDispatcher("/products.jsp");
            }
            break;
            case getBucketItems: {
                Object object = httpSession.getAttribute("products");
                this.logger.log(Level.INFO, "in bucket: " + object);
                List list = Collections.singletonList((Item) object);
                req.setAttribute("products", list);
                requestDispatcher = req.getRequestDispatcher("/checkout.jsp");
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
