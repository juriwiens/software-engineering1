package org.bonn.se.ws15.uebung8.views;

import org.bonn.se.ws15.uebung8.dtos.EnterDTO;
import org.bonn.se.ws15.uebung8.dtos.UserStoryDTO;
import org.bonn.se.ws15.uebung8.models.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.bonn.se.ws15.uebung8.utilities.CLIUtil.askFor;

public class EnterView {
    private final InputStream in;
    private final PrintStream out;
    private final PrintStream err;

    public EnterView(InputStream in, PrintStream out, PrintStream err) {
        this.in = in;
        this.out = out;
        this.err = err;
    }

    public UserStoryDTO askForUserStory(EnterDTO enter) throws IOException {
        out.println(enter.getCmdDescription());

        final OneToFiveValueFromStringBuilder oneToFiveBuilder = new OneToFiveValueFromStringBuilder();

        final Title title = askFor("Titel", new TitleFromStringBuilder(), in, out);
        final OneToFiveValue mehrwert = askFor("Mehrwert [1 - 5]", oneToFiveBuilder, in, out);
        final OneToFiveValue strafe = askFor("Strafe [1 - 5]", oneToFiveBuilder, in, out);
        final OneToFiveValue risiko = askFor("Risiko [1 - 5]", oneToFiveBuilder, in, out);
        final Aufwand aufwand = askFor("Aufwand [Fibonacci Zahl außer 20 statt 21]", new AufwandFromStringBuilder(),
                System.in, System.out);

        return new UserStoryDTO(title, mehrwert, strafe, risiko, aufwand);
    }

    public void showMaxUserStoriesErr(int maxUserStories) {
        out.printf("FEHLER: Die maximale Anzahl an User Stories (%d) ist bereits erreicht.%n", maxUserStories);
    }
}
