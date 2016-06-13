package com.rustedbrain.util.database;

import com.rustedbrain.model.Watches;
import com.rustedbrain.model.Account;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Alexey on 11.06.2016.
 */
public class DatabaseUtil {

    public static Account getUser(String username, String password, Session session) {
        return (Account) session.createCriteria(Account.class)
                .add(Restrictions.ilike("login", username))
                .add(Restrictions.ilike("password", password))
                .uniqueResult();
    }

    public static List getClockList(Watches.ClockType type, Session session) {
        if (type != null)
            switch (type) {
                case ECLOCK: {
                    return session.createCriteria(Watches.class).add(Restrictions.eq("type", "ECLOCK")).list();
                }
                case MECHClOCK: {
                    return session.createCriteria(Watches.class).add(Restrictions.eq("type", "MECHCLOCK")).list();
                }
            }
        return session.createCriteria(Watches.class).list();
    }

    public static void main(String[] args) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        System.out.println(getClockList(null, session));
    }

}
