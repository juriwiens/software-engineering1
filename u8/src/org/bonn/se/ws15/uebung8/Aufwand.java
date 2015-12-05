package org.bonn.se.ws15.uebung8;

import java.io.Serializable;
import java.math.BigDecimal;

public class Aufwand implements Serializable {
    private final Byte value;

    public Aufwand(Byte value) throws IllegalArgumentException {
        if (isValid(value)) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Aufwand muss eine Fibonacci-Zahl sein (Ausnahme: 20 statt 21).");
        }
    }

    public Aufwand(String value) throws IllegalArgumentException {
        this(Byte.parseByte(value));
    }

    public static boolean isValid(byte candidate) {
        return (candidate > 0 && candidate != 21 && FibonacciUtil.isFibonacci(new BigDecimal(candidate)))
                || candidate == 20;
    }

    public String toString() {
        return value.toString();
    }

    public double toDouble() {
        return value.doubleValue();
    }
}
