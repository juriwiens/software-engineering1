package org.bonn.se.ws15.uebung4;

public class Mehrwert {
    private final Byte mehrwert;

    public Mehrwert(byte mehrwert) throws IllegalArgumentException {
        if (isValid(mehrwert)) {
            this.mehrwert = mehrwert;
        } else {
            throw new IllegalArgumentException("Mehrwert muss zwischen 1 und 5 liegen.");
        }
    }

    public Mehrwert(String mehrwert) throws IllegalArgumentException {
        this(Byte.parseByte(mehrwert));
    }

    public static boolean isValid(byte candidate) {
        return candidate >= 1 && candidate <= 5;
    }

    public String toString() {
        return mehrwert.toString();
    }
}
