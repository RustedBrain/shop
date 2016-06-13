package com.rustedbrain.model;

import javax.persistence.*;


@Entity
public class Watches extends Item {

    @Enumerated(value = EnumType.STRING)
    private ClockType type;

    public ClockType getType() {
        return type;
    }

    public void setType(ClockType type) {
        this.type = type;
    }

    public enum ClockType {
        ECLOCK, MECHClOCK
    }
}
