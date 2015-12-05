package org.bonn.se.ws15.uebung8.commands;

import org.bonn.se.ws15.uebung8.UserStory;
import org.bonn.se.ws15.uebung8.ListContainer;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class Load {
    public static String getDescription() {
        return "load: Lädt persistierte User Stories.";
    }

    public static void run(ListContainer<UserStory> userStoryContainer, String fileName) {
        System.out.println(getDescription());

        try (final ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(fileName))) {
            userStoryContainer.replaceList((List<UserStory>) inStream.readObject());
            System.out.println("User Stories wurden erfolgreich aus " + fileName + " geladen.");
        } catch (Exception e) {
            System.err.println("FEHLER beim laden: " + e.getClass().getTypeName() + ": " + e.getMessage());
        }

    }
}
