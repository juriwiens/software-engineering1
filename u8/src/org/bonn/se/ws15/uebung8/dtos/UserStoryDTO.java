package org.bonn.se.ws15.uebung8.dtos;

import org.bonn.se.ws15.uebung8.models.*;

public class UserStoryDTO {
    private final UserStory userStory;

    public UserStoryDTO(Title title, OneToFiveValue mehrwert, OneToFiveValue strafe, OneToFiveValue risiko, Aufwand aufwand) {
        this.userStory = new UserStory(title, mehrwert, strafe, risiko, aufwand);
    }

    public UserStoryDTO(UserStory userStory) {
        this.userStory = userStory;
    }

    public Title getTitle() {
        return userStory.getTitle();
    }

    public OneToFiveValue getMehrwert() {
        return userStory.getMehrwert();
    }

    public OneToFiveValue getStrafe() {
        return userStory.getStrafe();
    }

    public OneToFiveValue getRisiko() {
        return userStory.getRisiko();
    }

    public Aufwand getAufwand() {
        return userStory.getAufwand();
    }

    public double calculatePrio() {
        return userStory.calculatePrio();
    }

    public UserStory toUserStory() {
        return userStory;
    }
}
