package com.rustedbrain.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cloth extends Item implements Comparable<Cloth>{

    @Column(name = "isMale")
    private boolean isMale;
    @Column(name = "size", nullable = false)
    private double size;

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    @Override
    public int compareTo(Cloth o) {
        return Double.compare(this.size, o.size);
    }
}
