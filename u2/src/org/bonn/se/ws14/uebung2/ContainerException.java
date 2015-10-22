package org.bonn.se.ws14.uebung2;

public class ContainerException extends Exception {
    public ContainerException(Member obj) {
        super("Das Member-Objekt mit der ID " + obj.getID() + " ist bereits vorhanden!");
    }
}
