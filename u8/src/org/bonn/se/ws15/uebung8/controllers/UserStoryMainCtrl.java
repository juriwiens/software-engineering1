package org.bonn.se.ws15.uebung8.controllers;

import org.bonn.se.ws15.uebung8.commands.*;
import org.bonn.se.ws15.uebung8.models.ListContainer;
import org.bonn.se.ws15.uebung8.models.UserStory;
import org.bonn.se.ws15.uebung8.views.CmdPromptView;

import java.io.IOException;
import java.util.HashMap;

public class UserStoryMainCtrl implements CmdEvaluator {
    private final HashMap<String, Command> commandMap;
    private final String storeFileName;
    protected final ListContainer<UserStory> userStoryContainer;
    private final CmdPromptView cmdPromptView;
    private final int maxUserStories;

    public UserStoryMainCtrl(HashMap<String, Command> commandMap,
                             String storeFileName,
                             ListContainer<UserStory> userStoryContainer,
                             int maxUserStories) {
        this.commandMap = commandMap;
        this.storeFileName = storeFileName;
        this.userStoryContainer = userStoryContainer;
        this.maxUserStories = maxUserStories;
        this.cmdPromptView = new CmdPromptView(this, System.in, System.out, System.err);

        addInitialCommands();
    }

    private void addInitialCommands() {
        commandMap.put("dump", new DumpCmd(userStoryContainer));
        commandMap.put("enter", new EnterCmd(userStoryContainer, maxUserStories));
        commandMap.put("help", new HelpCmd(commandMap));
        commandMap.put("load", new LoadCmd(userStoryContainer, storeFileName));
        commandMap.put("store", new StoreCmd(userStoryContainer, storeFileName));
        commandMap.put("exit", new ExitCmd());
    }

    public void execute() {
        cmdPromptView.prompt();
    }

    public void eval(String cmdStr) throws IOException {
        final Command cmd = commandMap.get(cmdStr);

        if (cmd != null) {
            cmd.execute();
        } else {
            System.out.println("Ungültiger Befehl. Tipp: 'help' eingeben.");
        }
    }
}
