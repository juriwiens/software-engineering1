package org.bonn.se.ws14.uebung2;

public interface Member {
    // ID ist eindeutig über eine Konstruktor zu belegen
    // --> Primärschlüssel zur Unterscheidung aller Member-Objekte
    Integer getID();

    String toString();
}
