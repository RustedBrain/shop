package com.rustedbrain.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Accessory extends Item implements Comparable<Accessory> {


    @Column(name = "size")
    private double size;

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public int compareTo(Accessory o) {
        return Double.compare(this.size, o.size);
    }

    @Override
    public String toString() {
        return "Accessory{" +
                "size=" + size +
                "} " + super.toString();
    }
}
