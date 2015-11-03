package org.bonn.se.ws15.uebung4;

public class TitleFromStringBuilder extends FromStringBuilder<Title> {
    public Title fromString(String str) throws IllegalArgumentException {
        return new Title(str);
    }
}
