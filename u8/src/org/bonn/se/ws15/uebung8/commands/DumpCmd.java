package org.bonn.se.ws15.uebung8.commands;

import org.bonn.se.ws15.uebung8.dtos.DumpDTO;
import org.bonn.se.ws15.uebung8.models.UserStory;
import org.bonn.se.ws15.uebung8.models.ListContainer;
import org.bonn.se.ws15.uebung8.views.DumpView;

public class DumpCmd implements Command {
    private final ListContainer<UserStory> userStoryContainer;
    private final DumpView view;

    public DumpCmd(ListContainer<UserStory> userStoryContainer) {
        this.userStoryContainer = userStoryContainer;
        this.view = new DumpView(System.out);
    }

    public String getDescription() {
        return "dump: Gibt User Stories nach Priorität sortiert aus.";
    }

    public void execute() {
        view.present(new DumpDTO(getDescription(), userStoryContainer.getList()));
    }
}
