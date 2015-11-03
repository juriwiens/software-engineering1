package org.bonn.se.ws15.uebung4.commands;

public class Help {
    public static String getDescription() {
        return "help: Listet verfügbare Befehle.";
    }

    public static void run() {
        System.out.println(getDescription());
        System.out.println(Enter.getDescription());
        System.out.println(Store.getDescription());
        System.out.println(Load.getDescription());
        System.out.println(Dump.getDescription());
        System.out.println("exit: Beendet Programm.");
    }
}
