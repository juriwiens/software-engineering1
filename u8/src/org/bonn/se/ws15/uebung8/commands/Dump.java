package org.bonn.se.ws15.uebung8.commands;

import org.bonn.se.ws15.uebung8.UserStory;
import org.bonn.se.ws15.uebung8.ListContainer;

public class Dump {
    public static String getDescription() {
        return "dump: Gibt User Stories nach Priorität sortiert aus.";
    }

    public static void run(ListContainer<UserStory> userStoryContainer) {
        System.out.println(getDescription());

        final String headerFormat = "| %-20s | %-8s | %-6s | %-6s | %-7s | %-5s |%n";
        final String entryFormat = "| %-20s | %8s | %6s | %6s | %7s | %5.3f |%n";

        System.out.printf(headerFormat, "TITEL", "MEHRWERT", "STRAFE", "RISIKO", "AUFWAND", "PRIO");
        for (UserStory us : userStoryContainer.getList()) {
            System.out.printf(entryFormat, us.getTitle(), us.getMehrwert(), us.getStrafe(), us.getRisiko(), us.getAufwand(), us.calculatePrio());
        }
    }
}
