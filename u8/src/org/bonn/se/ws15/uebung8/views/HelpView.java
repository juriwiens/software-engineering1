package org.bonn.se.ws15.uebung8.views;

import org.bonn.se.ws15.uebung8.commands.Command;

import java.io.PrintStream;
import java.util.HashMap;

public class HelpView {
    private final PrintStream out;

    public HelpView(PrintStream out) {
        this.out = out;
    }

    public void present(HashMap<String, Command> commandMap) {
        for (Command cmd : commandMap.values()) {
            out.println(cmd.getDescription());
        }
    };
}
