package org.bonn.se.ws15.uebung4;

public class OneToFiveValueFromStringBuilder extends FromStringBuilder<OneToFiveValue> {
    @Override
    public OneToFiveValue fromString(String str) {
        return new OneToFiveValue(str);
    }
}
