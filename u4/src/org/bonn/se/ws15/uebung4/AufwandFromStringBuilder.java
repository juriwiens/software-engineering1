package org.bonn.se.ws15.uebung4;

public class AufwandFromStringBuilder extends FromStringBuilder<Aufwand> {
    @Override
    public Aufwand fromString(String str) {
        return new Aufwand(str);
    }
}
