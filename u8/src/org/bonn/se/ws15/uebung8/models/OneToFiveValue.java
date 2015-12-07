package org.bonn.se.ws15.uebung8.models;

import java.io.Serializable;

public class OneToFiveValue implements Serializable {
    private final Byte value;

    public OneToFiveValue(byte value) throws IllegalArgumentException {
        if (isValid(value)) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Wert muss zwischen 1 und 5 liegen.");
        }
    }

    public OneToFiveValue(String value) throws IllegalArgumentException {
        this(Byte.parseByte(value));
    }

    public static boolean isValid(byte candidate) {
        return candidate >= 1 && candidate <= 5;
    }

    public String toString() {
        return value.toString();
    }

    public double toDouble() {
        return value.doubleValue();
    }
}
