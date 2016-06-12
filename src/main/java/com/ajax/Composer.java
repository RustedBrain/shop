package com.ajax;

/**
 * Created by Anastasiia on 09.06.2016.
 */
public class Composer {

    private String id;
    private String firstName;
    private String lastName;
    private String category;


    public Composer (String id, String firstName, String lastName, String category) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
