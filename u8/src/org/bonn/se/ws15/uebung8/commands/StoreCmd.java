package org.bonn.se.ws15.uebung8.commands;

import org.bonn.se.ws15.uebung8.models.ListContainer;
import org.bonn.se.ws15.uebung8.models.UserStory;
import org.bonn.se.ws15.uebung8.views.StoreView;

import java.io.*;

public class StoreCmd implements Command {
    private final ListContainer<UserStory> userStories;
    private final String storeFileName;
    private final StoreView view;

    public StoreCmd(ListContainer<UserStory> userStories, String storeFileName) {
        this.userStories = userStories;
        this.storeFileName = storeFileName;
        this.view = new StoreView(System.out, System.err);
    }

    public String getDescription() {
        return "store: Persistiert User Stories.";
    }

    public void execute() {
        view.showCmdDescription(getDescription());

        try (final ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(storeFileName))) {
            outStream.writeObject(userStories.getList());
            view.showSuccess(storeFileName);
        } catch (Exception e) {
            view.showError(e);
        }
    }
}
