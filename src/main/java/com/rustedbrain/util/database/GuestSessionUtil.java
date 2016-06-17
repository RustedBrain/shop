package com.rustedbrain.util.database;

import com.rustedbrain.controller.BucketServlet;
import com.rustedbrain.model.GuestSession;
import com.rustedbrain.model.Item;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Alexey on 16.06.2016.
 */
public class GuestSessionUtil {

    private static Logger logger = Logger.getLogger(BucketServlet.class.getName());

    public static GuestSession getGuestSession(String remoteAddress, Session session) {
        GuestSession guestSession = (GuestSession) session
                .createCriteria(GuestSession.class)
                .add(Restrictions.like("ip", remoteAddress))
                .uniqueResult();
        if (guestSession == null) {
            guestSession = new GuestSession();
            guestSession.setName("Session");
            guestSession.setRegistrationDate(new Date(System.currentTimeMillis()));
            guestSession.setIp(remoteAddress);
        }
        return guestSession;
    }

    public static List<Item> getItemsBucket(GuestSession guestSession) {
        List<Item> items = guestSession.getItemsBucket();
        if (items == null)
            items = new ArrayList<>();
        return items;
    }

    public static Item.ItemCategory addItemToBucket(Session session, HttpServletRequest req) {

        GuestSession guestSession = GuestSessionUtil.getGuestSession(req.getRemoteAddr(), session);
        List<Item> items = GuestSessionUtil.getItemsBucket(guestSession);

        Item.ItemCategory itemCategory = Item.ItemCategory.valueOf(req.getParameter("itemCategory").trim().toUpperCase());

        Item accessory = (Item) session.get(Item.class, Integer.valueOf(req.getParameter("itemId").trim()));
        logger.log(Level.INFO, "Accessory " + accessory + " now will be added to guestSession");
        items.add(accessory);

        session.saveOrUpdate(guestSession);
        logger.log(Level.INFO, guestSession + " successfully updated, added " + guestSession.getItemsBucket());
        session.flush();
        session.close();
        return itemCategory;
    }

    public static void deleteItemFromBucket(Session session, HttpServletRequest req) {
        GuestSession guestSession = GuestSessionUtil.getGuestSession(req.getRemoteAddr(), session);
        List<Item> items = GuestSessionUtil.getItemsBucket(guestSession);

        Item accessory = (Item) session.get(Item.class, Integer.valueOf(req.getParameter("itemId").trim()));
        logger.log(Level.INFO, "Accessory " + accessory + " now will be added to guestSession");
        items.remove(accessory);

        session.saveOrUpdate(guestSession);
        logger.log(Level.INFO, guestSession + " successfully updated, added " + guestSession.getItemsBucket());
        session.flush();
        session.close();
    }
}
