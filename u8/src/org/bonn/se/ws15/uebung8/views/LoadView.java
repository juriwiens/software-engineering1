package org.bonn.se.ws15.uebung8.views;

import java.io.PrintStream;

public class LoadView {
    private final PrintStream out;
    private final PrintStream err;

    public LoadView(PrintStream out, PrintStream err) {
        this.out = out;
        this.err = err;
    }

    public void showCmdDescription(String cmdDescription) {
        out.println(cmdDescription);
    }

    public void showSuccess(String storeFileName) {
        out.println("User Stories wurden erfolgreich aus " + storeFileName + " geladen.");
    }

    public void showError(Exception e) {
        err.println("FEHLER beim laden: " + e.getClass().getTypeName() + ": " + e.getMessage());
    }
}
