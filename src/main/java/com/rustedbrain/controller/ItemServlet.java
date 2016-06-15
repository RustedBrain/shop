package com.rustedbrain.controller;


import com.rustedbrain.util.TestEntitys;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(
        description = "Servlet that resolve all items requests",
        urlPatterns = "/ItemServlet"
)
public class ItemServlet extends HttpServlet {

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
