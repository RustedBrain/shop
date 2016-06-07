package com.rustedbrain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.sql.Date;
import java.util.ArrayList;

@Entity
public class User extends DatabaseEntity {

    @Column(name = "surname")
    private String surname;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "totalPriceSpent")
    private double totalPriceSpent;

    @ManyToMany
    private ArrayList<Item> itemsBought;
    @ManyToMany
    private ArrayList<Item> itemsBucket;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return Double.compare(user.totalPriceSpent, totalPriceSpent) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(totalPriceSpent);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public double getTotalPriceSpent() {
        return totalPriceSpent;
    }

    public void setTotalPriceSpent(double totalPriceSpent) {
        this.totalPriceSpent = totalPriceSpent;
    }

    public ArrayList<Item> getItemsBought() {
        return itemsBought;
    }

    public void setItemsBought(ArrayList<Item> itemsBought) {
        this.itemsBought = itemsBought;
    }

    public ArrayList<Item> getItemsBucket() {
        return itemsBucket;
    }

    public void setItemsBucket(ArrayList<Item> itemsBucket) {
        this.itemsBucket = itemsBucket;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
