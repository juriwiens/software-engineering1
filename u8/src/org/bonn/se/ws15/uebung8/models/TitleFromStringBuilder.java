package org.bonn.se.ws15.uebung8.models;

public class TitleFromStringBuilder extends FromStringBuilder<Title> {
    public Title fromString(String str) throws IllegalArgumentException {
        return new Title(str);
    }
}
