package org.bonn.se.ws15.uebung2;

public class ContainerException extends Exception {
    public ContainerException(Member obj) {
        super("Das Member-Objekt mit der ID " + obj.getID() + " ist bereits vorhanden!");
    }
}
