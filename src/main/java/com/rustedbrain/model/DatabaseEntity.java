package com.rustedbrain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
abstract class DatabaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "registrationDate", nullable = false)
    private Date registrationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "DatabaseEntity{" +
                "name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
