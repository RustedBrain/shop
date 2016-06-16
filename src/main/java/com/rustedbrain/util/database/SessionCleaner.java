package com.rustedbrain.util.database;

import com.rustedbrain.model.GuestSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.sql.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alexey on 16.06.2016.
 */
public class SessionCleaner {

    private SessionFactory factory;
    private Timer timer;

    public SessionCleaner(SessionFactory factory) {
        this.factory = factory;
        this.timer = new Timer(true);
        this.timer.schedule(new CleanerTask(), TimeUnit.SECONDS.toMillis(30), TimeUnit.MINUTES.toMillis(5));
    }

    private class CleanerTask extends TimerTask {

        @Override
        public void run() {
            Session session = factory.openSession();

            List<GuestSession> guestSessions = session
                    .createCriteria(GuestSession.class)
                    .add(Restrictions.le("registrationDate", new Date(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(5))))
                    .list();

            guestSessions.stream().forEach(session::delete);

            session.flush();
            session.close();
        }
    }

}
