package com.rustedbrain.util.database;

import com.rustedbrain.model.Accessory;
import com.rustedbrain.model.GuestSession;
import com.rustedbrain.model.Item;
import com.rustedbrain.model.Watches;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 16.06.2016.
 */
public class GuestSessionUtil {

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

        switch (itemCategory) {
            case BRASLETS: {
                Accessory accessory = (Accessory) session.get(Accessory.class, Integer.valueOf(req.getParameter("itemId").trim()));
                items.add(accessory);
            }
            break;
            case EARINGS: {
                Accessory accessory = (Accessory) session.get(Accessory.class, Integer.valueOf(req.getParameter("itemId").trim()));
                items.add(accessory);
            }
            break;
            case WATCHES: {
                Watches watches = (Watches) session.get(Watches.class, Integer.valueOf(req.getParameter("itemId").trim()));
                items.add(watches);
            }
            break;
            case BRELOQUES: {
                Accessory accessory = (Accessory) session.get(Accessory.class, Integer.valueOf(req.getParameter("itemId").trim()));
                items.add(accessory);
            }
            break;
        }

        session.saveOrUpdate(guestSession);
        session.flush();
        session.close();

        return itemCategory;
    }
}