package com.rustedbrain.controller;


import com.rustedbrain.model.Accessory;
import com.rustedbrain.model.Item;
import com.rustedbrain.util.database.GuestSessionUtil;
import com.rustedbrain.util.database.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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

    private Logger logger;
    private ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.logger = Logger.getLogger(AppServlet.class.getName());
        this.context = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SubAction action = SubAction.valueOf(req.getParameter("subAction").trim());
        RequestDispatcher requestDispatcher;
        Session session = HibernateUtil.getSessionFactory().openSession();

        switch (action) {
            case getAll: {
                req.setAttribute("all", session.createCriteria(Item.class).list());
                requestDispatcher = req.getRequestDispatcher("/products.jsp");
            }
            break;
            case getEarings: {
                req.setAttribute("earings", session.createCriteria(Item.class)
                        .add(Restrictions.like("category", Item.ItemCategory.EARINGS))
                        .list());
                requestDispatcher = req.getRequestDispatcher("/earings.jsp");
            }
            break;
            case getWatches: {
                req.setAttribute("watches", session.createCriteria(Item.class)
                        .add(Restrictions.like("category", Item.ItemCategory.WATCHES))
                        .list());
                requestDispatcher = req.getRequestDispatcher("/watches.jsp");
            }
            break;
            case getBraslets: {
                req.setAttribute("braslets", session.createCriteria(Accessory.class)
                        .add(Restrictions.like("category", Item.ItemCategory.BRASLETS))
                        .list());
                requestDispatcher = req.getRequestDispatcher("/braslets.jsp");
            }
            break;
            case getBreloques: {
                req.setAttribute("breloques", session.createCriteria(Accessory.class)
                        .add(Restrictions.like("category", Item.ItemCategory.BRELOQUES))
                        .list());
                requestDispatcher = req.getRequestDispatcher("/breloques.jsp");
            }
            break;
            default: {
                requestDispatcher = req.getRequestDispatcher("/error.jsp");
            }
        }

        req.setAttribute("products", GuestSessionUtil.getItemsBucket(GuestSessionUtil.getGuestSession(req.getRemoteAddr(), session)).size());
        session.close();
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
