package com.rustedbrain.controller;

import com.rustedbrain.model.GuestSession;
import com.rustedbrain.model.Item;
import com.rustedbrain.util.database.GuestSessionUtil;
import com.rustedbrain.util.database.HibernateUtil;
import com.rustedbrain.util.database.SessionCleaner;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/BucketServlet")
public class BucketServlet extends HttpServlet {

    private Logger logger;
    private SessionCleaner sessionCleaner;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.logger = Logger.getLogger(BucketServlet.class.getName());
        this.sessionCleaner = new SessionCleaner(HibernateUtil.getSessionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SubAction action = SubAction.valueOf(req.getParameter("subAction").trim());
        RequestDispatcher requestDispatcher;

        switch (action) {
            case addItem: {
                Item.ItemCategory itemCategory = GuestSessionUtil.addItemToBucket(HibernateUtil.getSessionFactory().openSession(), req);

                switch (itemCategory) {
                    case BRASLETS: {
                        requestDispatcher = req.getRequestDispatcher("/AppServlet?mainAction=getItems&subAction=getBraslets");
                    }
                    break;
                    case EARINGS: {
                        requestDispatcher = req.getRequestDispatcher("/AppServlet?mainAction=getItems&subAction=getEarings");
                    }
                    break;
                    case BRELOQUES: {
                        requestDispatcher = req.getRequestDispatcher("/AppServlet?mainAction=getItems&subAction=getBreloques");
                    }
                    break;
                    case WATCHES: {
                        requestDispatcher = req.getRequestDispatcher("/AppServlet?mainAction=getItems&subAction=getWatches");
                    }
                    break;
                    default: {
                        requestDispatcher = req.getRequestDispatcher("/AppServlet?mainAction=getItems&subAction=getAll");
                    }
                }

            }
            break;
            case getBucketItems: {
                Session session = HibernateUtil.getSessionFactory().openSession();
                GuestSession guestSession = GuestSessionUtil.getGuestSession(req.getRemoteAddr(), session);
                logger.log(Level.INFO, guestSession + ", items: " + guestSession.getItemsBucket());
                req.setAttribute("products", ((SessionImplementor) session).getPersistenceContext().unproxy(guestSession.getItemsBucket()));
                session.close();
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
