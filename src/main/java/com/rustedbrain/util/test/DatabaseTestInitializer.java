package com.rustedbrain.util.test;

import com.rustedbrain.model.Accessory;
import com.rustedbrain.model.Account;
import com.rustedbrain.model.Item;
import com.rustedbrain.util.database.HibernateUtil;
import org.hibernate.Session;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by alex on 07.06.16.
 */
public class DatabaseTestInitializer {

    private static final int TEST_INIT_USERS_COUNT = 10;
    private static final int TEST_INIT_USERS_ITEMS_IN_BUCKET_COUNT = 3;
    private static final int TEST_INIT_USERS_ITEMS_BOUGHT_COUNT = 3;
    private static final int TEST_INIT_ITEMS_COUNT = 10;

    public static void initUsers(Session session) {
        for (int i = 0; i < TEST_INIT_USERS_COUNT; i++) {
            session.saveOrUpdate(createUser(i));
        }
        session.flush();
    }

    public static void initUsersItemsInBucket(Session session) {
        List objectUsers = session.createCriteria(Account.class).list();
        if (objectUsers == null || objectUsers.isEmpty()) {
            initUsers(session);
            objectUsers = session.createCriteria(Account.class).list();
        }
        for (Object objectUser : objectUsers) {
            Account user = (Account) objectUser;
            List<Item> items = new ArrayList<>();
            for (int i = 0; i < TEST_INIT_USERS_ITEMS_IN_BUCKET_COUNT; i++) {
                items.add(createAccessory(i));
            }
            user.setItemsBucket(items);
        }
        session.flush();
    }

    public static void initUsersItemsBought(Session session) {
        List objectUsers = session.createCriteria(Account.class).list();
        if (objectUsers == null || objectUsers.isEmpty()) {
            initUsers(session);
            objectUsers = session.createCriteria(Account.class).list();
        }
        for (Object objectUser : objectUsers) {
            Account user = (Account) objectUser;
            List<Item> items = new ArrayList<>();
            for (int i = 0; i < TEST_INIT_USERS_ITEMS_BOUGHT_COUNT; i++) {
                items.add(createAccessory(i));
            }
            user.setItemsBought(items);
        }
        session.flush();
    }

    private static Accessory createAccessory(int i) {
        Random random = new Random();
        Accessory accessory = new Accessory();
        accessory.setName("accessory" + i);
        accessory.setSize(i);
        accessory.setRegistrationDate(new Date(System.currentTimeMillis()));
        accessory.setCategory(Accessory.ItemCategory.values()[random.nextInt(Accessory.ItemCategory.values().length)]);
        accessory.setDescription("description" + i);
        accessory.setPrice(i);
        accessory.setWeight(i);
        accessory.setMale(random.nextBoolean());
        accessory.setDiscount(i);
        accessory.setStyle(Accessory.ItemStyle.values()[random.nextInt(Accessory.ItemStyle.values().length)]);
        return accessory;
    }

    private static Account createUser(int i) {
        Account user = new Account();
        user.setLogin("Login" + i);
        user.setName("Name" + i);
        user.setSurname("Surname" + i);
        user.setPassword("Password" + i);
        user.setRegistrationDate(new Date(System.currentTimeMillis() - i));
        user.setBirthday(new Date(System.currentTimeMillis() - i));
        return user;
    }


    public static void initItems(Session session) {
        for (int i = 0; i < TEST_INIT_ITEMS_COUNT; i++) {
            session.saveOrUpdate(createAccessory(i));
        }
        session.flush();
        session.close();
    }

    public static void main(String[] args) {
        initItems(HibernateUtil.getSessionFactory().openSession());
    }
}
