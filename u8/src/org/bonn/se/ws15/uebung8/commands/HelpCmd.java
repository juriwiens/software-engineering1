package org.bonn.se.ws15.uebung8.commands;

import org.bonn.se.ws15.uebung8.views.HelpView;

import java.util.HashMap;

public class HelpCmd implements Command {
    private final HashMap<String, Command> commandMap;
    private final HelpView view;

    public HelpCmd(HashMap<String, Command> commandMap) {
        this.commandMap = commandMap;
        this.view = new HelpView(System.out);
    }

    public String getDescription() {
        return "help: Listet verfügbare Befehle.";
    }

    public void execute() {
        view.present(commandMap);
    }
}
