package org.bonn.se.ws15.uebung8;

import java.io.Serializable;

public class UserStory implements Serializable {
    private final Title title;

    private final OneToFiveValue mehrwert;

    private final OneToFiveValue strafe;

    private final OneToFiveValue risiko;

    private final Aufwand aufwand;

    public UserStory(Title title, OneToFiveValue mehrwert, OneToFiveValue strafe, OneToFiveValue risiko, Aufwand aufwand) {
        this.title = title;
        this.mehrwert = mehrwert;
        this.strafe = strafe;
        this.risiko = risiko;
        this.aufwand = aufwand;
    }

    public Title getTitle() {
        return title;
    }

    public OneToFiveValue getMehrwert() {
        return mehrwert;
    }

    public OneToFiveValue getStrafe() {
        return strafe;
    }

    public OneToFiveValue getRisiko() {
        return risiko;
    }

    public Aufwand getAufwand() {
        return aufwand;
    }

    public double calculatePrio() {
        return (mehrwert.toDouble() + strafe.toDouble())/(aufwand.toDouble() + risiko.toDouble());
    }

    @Override
    public String toString() {
        return String.format("UserStory {titel: %s, mehrwert: %s, strafe: %s, risiko: %s, aufwand: %s, prio: %f}",
                title, mehrwert, strafe, risiko, aufwand, calculatePrio());
    }
}
