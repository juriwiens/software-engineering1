package org.bonn.se.ws15.uebung8.models;

import java.io.Serializable;

public class Title implements Serializable {
    private final String title;

    public Title(String title) throws IllegalArgumentException {
        if (isValid(title)) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Titel darf nicht leer sein!");
        }
    }

    public static boolean isValid(String candidate) {
        return !candidate.trim().isEmpty();
    }

    public String toString() {
        return this.title;
    }
}
