package org.bonn.se.ws15.uebung8.dtos;

import org.bonn.se.ws15.uebung8.models.UserStory;

import java.util.ArrayList;
import java.util.List;

public class DumpDTO {
    private final String cmdDescription;
    private final List<UserStoryDTO> userStories;

    public DumpDTO(String cmdDescription, List<UserStory> userStories) {
        this.cmdDescription = cmdDescription;
        this.userStories = mapUserStoriesToDTOs(userStories);
    }

    private List<UserStoryDTO> mapUserStoriesToDTOs(List<UserStory> userStories) {
        final List<UserStoryDTO> list = new ArrayList<>();
        for (UserStory us : userStories) {
            list.add(new UserStoryDTO(us));
        }
        return list;
    }

    public String getCmdDescription() {
        return cmdDescription;
    }

    public List<UserStoryDTO> getUserStories() {
        return userStories;
    }
}
