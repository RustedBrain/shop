package com.rustedbrain.controller;

import com.rustedbrain.model.Clock;
import com.rustedbrain.model.User;
import com.rustedbrain.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Alexey on 11.06.2016.
 */
public class DatabaseUtil {

    public static User getUser(String username, String password, Session session) {
        return (User) session.createCriteria(User.class)
                .add(Restrictions.ilike("login", username))
                .add(Restrictions.ilike("password", password))
                .uniqueResult();
    }

    public static List getClockList(Clock.ClockType type, Session session) {
        if (type != null)
            switch (type) {
                case ECLOCK: {
                    return session.createCriteria(Clock.class).add(Restrictions.eq("type", "ECLOCK")).list();
                }
                case MECHClOCK: {
                    return session.createCriteria(Clock.class).add(Restrictions.eq("type", "MECHCLOCK")).list();
                }
            }
        return session.createCriteria(Clock.class).list();
    }

    public static void main(String[] args) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        System.out.println(getClockList(null, session));
    }

}
