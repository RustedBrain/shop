package com.rustedbrain.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item extends DatabaseEntity {

    @Column(name = "count")
    private int count;
    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;
    @Column(name = "weight")
    private double weight;
    @Enumerated(value = EnumType.STRING)
    private ItemCategory category;
    @Enumerated(value = EnumType.STRING)
    private ItemStyle style;
    @Column(name = "discount")
    private double discount;
    @Column(name = "isMale")
    private boolean isMale;
    @Enumerated(value = EnumType.STRING)
    private ItemColor color;

    @Override
    public String toString() {
        return "Item{" +
                "price=" + price +
                ", style=" + style +
                ", isMale=" + isMale +
                "} " + super.toString();
    }

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

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
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

    public ItemStyle getStyle() {
        return style;
    }

    public void setStyle(ItemStyle style) {
        this.style = style;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public ItemColor getColor() {
        return color;
    }

    public void setColor(ItemColor color) {
        this.color = color;
    }

    public enum ItemCategory {
        EARINGS, BRASLETS, BRELOQUES, WATCHES
    }

    public enum ItemStyle {
        CLASSIC, GOTHIC, MODERN
    }

    public enum ItemColor {
        BLACK, WHITE, GREEN, GREY, YELLOW, BROWN, PURPULE, MAROON, RED
    }
}
