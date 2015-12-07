package org.bonn.se.ws15.uebung8.views;

import java.io.PrintStream;

public class StoreView {
    private final PrintStream out;
    private final PrintStream err;

    public StoreView(PrintStream out, PrintStream err) {
        this.out = out;
        this.err = err;
    }

    public void showCmdDescription(String cmdDescription) {
        out.println(cmdDescription);
    }

    public void showSuccess(String storeFileName) {
        out.println("User Stories wurden erfolgreich in " + storeFileName + " persistiert.");
    }

    public void showError(Exception e) {
        err.println("FEHLER beim persistieren: " + e.getClass().getTypeName() + ": " + e.getMessage());
    }

}
