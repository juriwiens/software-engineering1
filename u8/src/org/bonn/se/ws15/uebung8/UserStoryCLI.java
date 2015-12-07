package org.bonn.se.ws15.uebung8;

import org.bonn.se.ws15.uebung8.commands.Command;
import org.bonn.se.ws15.uebung8.controllers.UserStoryMainCtrl;
import org.bonn.se.ws15.uebung8.models.ListContainer;
import org.bonn.se.ws15.uebung8.models.UserStory;

import java.util.ArrayList;
import java.util.HashMap;

public class UserStoryCLI {
    public static void main(String[] args) {
        final HashMap<String, Command> cmdMap = new HashMap<>();
        final ListContainer<UserStory> userStoryContainer = new ListContainer<>(new ArrayList<UserStory>());

        final UserStoryMainCtrl mainCtrl = new UserStoryMainCtrl(
                cmdMap,
                Config.storeFileName,
                userStoryContainer,
                Config.maxUserStories);
        mainCtrl.execute();
    }
}
