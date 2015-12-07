package org.bonn.se.ws15.uebung8.commands;

import org.bonn.se.ws15.uebung8.dtos.UserStoryDTO;
import org.bonn.se.ws15.uebung8.models.ListContainer;
import org.bonn.se.ws15.uebung8.models.UserStory;
import org.bonn.se.ws15.uebung8.dtos.EnterDTO;
import org.bonn.se.ws15.uebung8.views.EnterView;

import java.io.IOException;
import java.util.Comparator;

public class EnterCmd implements Command {
    private final ListContainer<UserStory> userStories;
    private final int maxUserStories;
    private final EnterView view;

    public EnterCmd(ListContainer<UserStory> userStories, int maxUserStories) {
        this.userStories = userStories;
        this.maxUserStories = maxUserStories;
        this.view = new EnterView(System.in, System.out, System.err);
    }

    public String getDescription() {
        return "enter: Startet Eingabedialog einer neuen User Story.";
    }

    public void execute() throws IOException {
        if (userStories.getList().size() >= maxUserStories) {
            view.showMaxUserStoriesErr(maxUserStories);
            return;
        }

        final EnterDTO enterDTO = new EnterDTO(getDescription());
        final UserStoryDTO userStoryDTO = view.askForUserStory(enterDTO);
        userStories.getList().add(userStoryDTO.toUserStory());
        userStories.getList().sort(new Comparator<UserStory>() {
            @Override
            public int compare(UserStory o1, UserStory o2) {
                return -Double.compare(o1.calculatePrio(), o2.calculatePrio());
            }
        });
    }
}
