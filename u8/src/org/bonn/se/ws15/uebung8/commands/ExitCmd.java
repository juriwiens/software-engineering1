package org.bonn.se.ws15.uebung8.commands;

import java.io.IOException;

public class ExitCmd implements Command {

    public String getDescription() {
        return "exit: Beendet die Anwendung.";
    }

    public void execute() throws IOException {
        System.exit(0);
    }
}
