package org.bonn.se.ws15.uebung4.commands;

import org.bonn.se.ws15.uebung4.*;

import java.io.IOException;
import java.util.Comparator;

import static org.bonn.se.ws15.uebung4.CLIUtil.askFor;

public class Enter {
    public static String getDescription() {
        return "enter: Startet Eingabedialog einer neuen User Story.";
    }

    public static void run(ListContainer<UserStory> userStories) throws IOException {
        System.out.println(getDescription());

        if (userStories.getList().size() >= 10) {
            System.out.println("FEHLER: Die maximale Anzahl an User Stories (10) ist bereits erreicht.");
            return;
        }

        final OneToFiveValueFromStringBuilder oneToFiveBuilder = new OneToFiveValueFromStringBuilder();

        final Title title = askFor("Titel", new TitleFromStringBuilder());
        final OneToFiveValue mehrwert = askFor("Mehrwert [1 - 5]", oneToFiveBuilder);
        final OneToFiveValue strafe = askFor("Strafe [1 - 5]", oneToFiveBuilder);
        final OneToFiveValue risiko = askFor("Risiko [1 - 5]", oneToFiveBuilder);
        final Aufwand aufwand = askFor("Aufwand [Fibonacci Zahl außer 20 statt 21]", new AufwandFromStringBuilder());

        userStories.getList().add(new UserStory(title, mehrwert, strafe, risiko, aufwand));
        userStories.getList().sort(new Comparator<UserStory>() {
            @Override
            public int compare(UserStory o1, UserStory o2) {
                return -Double.compare(o1.calculatePrio(), o2.calculatePrio());
            }
        });
    }
}
