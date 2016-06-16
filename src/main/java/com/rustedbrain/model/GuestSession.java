package com.rustedbrain.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class GuestSession extends DatabaseEntity {

    @Column(name = "ip")
    private String ip;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "itembucket_guest",
            joinColumns = {@JoinColumn(name = "guest_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private List<Item> itemsBucket;

    public List<Item> getItemsBucket() {
        return itemsBucket;
    }

    public void setItemsBucket(List<Item> itemsBucket) {
        this.itemsBucket = itemsBucket;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "GuestSession{" +
                "ip='" + ip + '\'' +
                '}';
    }
}
