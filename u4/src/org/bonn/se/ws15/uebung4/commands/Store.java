package org.bonn.se.ws15.uebung4.commands;

import org.bonn.se.ws15.uebung4.ListContainer;

import java.io.*;

public class Store {
    public static String getDescription() {
        return "store: Persistiert User Stories.";
    }

    public static void run(ListContainer userStories, String fileName) {
        try (final ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outStream.writeObject(userStories.getList());
            System.out.println("User Stories wurden erfolgreich in " + fileName + " persistiert.");
        } catch (Exception e) {
            System.out.println("FEHLER beim persistieren: " + e.getClass().getTypeName() + ": " + e.getMessage());
        }
    }
}
