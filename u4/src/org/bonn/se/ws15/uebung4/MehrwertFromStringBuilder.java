package org.bonn.se.ws15.uebung4;

public class MehrwertFromStringBuilder extends FromStringBuilder<Mehrwert>{

    @Override
    public Mehrwert fromString(String str) {
        return new Mehrwert(str);
    }
}
