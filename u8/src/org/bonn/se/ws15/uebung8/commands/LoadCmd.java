package org.bonn.se.ws15.uebung8.commands;

import org.bonn.se.ws15.uebung8.models.ListContainer;
import org.bonn.se.ws15.uebung8.models.UserStory;
import org.bonn.se.ws15.uebung8.views.LoadView;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class LoadCmd implements Command {
    private final ListContainer<UserStory> userStoryContainer;
    private final String storeFileName;
    private final LoadView view;

    public LoadCmd(ListContainer<UserStory> userStoryContainer, String fileName) {
        this.userStoryContainer = userStoryContainer;
        this.storeFileName = fileName;
        this.view = new LoadView(System.out, System.err);
    }

    public String getDescription() {
        return "load: Lädt persistierte User Stories.";
    }

    public void execute() {
        view.showCmdDescription(getDescription());

        try (final ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(storeFileName))) {
            userStoryContainer.replaceList((List<UserStory>) inStream.readObject());
            view.showSuccess(storeFileName);
        } catch (Exception e) {
            view.showError(e);
        }

    }
}
