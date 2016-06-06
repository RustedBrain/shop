package com.rustedbrain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by alex on 06.06.16.
 */
@Entity
public abstract class Item extends DatabaseEntity{

    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "description")
    private String description;
    @Column(name = "weight")
    private double weight;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    @Column(name = "discount")
    private double discount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        return Double.compare(item.price, price) == 0 && category.equals(item.category);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + category.hashCode();
        return result;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public enum Category{
        PANTS, BOOTS
    }
}
