package com.rustedbrain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by alex on 06.06.16.
 */
@Entity
public class Clock extends Item {

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
