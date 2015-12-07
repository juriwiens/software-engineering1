package org.bonn.se.ws15.uebung8.views;

import org.bonn.se.ws15.uebung8.dtos.DumpDTO;
import org.bonn.se.ws15.uebung8.dtos.UserStoryDTO;

import java.io.PrintStream;

public class DumpView {
    private final PrintStream out;

    public DumpView(PrintStream out) {
        this.out = out;
    }

    public void present(DumpDTO dump) {
        out.println(dump.getCmdDescription());

        final String headerFormat = "| %-20s | %-8s | %-6s | %-6s | %-7s | %-5s |%n";
        final String entryFormat = "| %-20s | %8s | %6s | %6s | %7s | %5.3f |%n";

        out.printf(headerFormat, "TITEL", "MEHRWERT", "STRAFE", "RISIKO", "AUFWAND", "PRIO");
        for (UserStoryDTO us : dump.getUserStories()) {
            out.printf(entryFormat, us.getTitle(), us.getMehrwert(), us.getStrafe(), us.getRisiko(), us.getAufwand(), us.calculatePrio());
        }
    }
}
