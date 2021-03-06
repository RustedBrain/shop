package com.rustedbrain.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Account extends DatabaseEntity {

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "itembought_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private List<Item> itemsBought;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "itembucket_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private List<Item> itemsBucket;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account user = (Account) o;

        return Double.compare(user.totalPriceSpent, totalPriceSpent) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(totalPriceSpent);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Account{" +
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

    public List<Item> getItemsBought() {
        return itemsBought;
    }

    public void setItemsBought(List<Item> itemsBought) {
        this.itemsBought = itemsBought;
    }

    public List<Item> getItemsBucket() {
        return itemsBucket;
    }

    public void setItemsBucket(List<Item> itemsBucket) {
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
