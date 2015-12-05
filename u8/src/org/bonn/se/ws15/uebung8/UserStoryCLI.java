package org.bonn.se.ws15.uebung8;

import org.bonn.se.ws15.uebung8.commands.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UserStoryCLI {
    private static String storeFileName = "data.ser";

    protected static final ListContainer<UserStory> userStoryContainer = new ListContainer<>(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        run();
    }

    private static void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;

        //noinspection InfiniteLoopStatement
        while (true) {
            System.out.print("UserStoryCLI > ");
            s = in.readLine();

            evalCommand(s);
        }
    }

    private static void evalCommand(String cmd) throws IOException {
        switch (cmd) {
            case "enter":
                Enter.run(userStoryContainer);
                break;
            case "store":
                Store.run(userStoryContainer, storeFileName);
                break;
            case "load":
                Load.run(userStoryContainer, storeFileName);
                break;
            case "dump":
                Dump.run(userStoryContainer);
                break;
            case "help":
                Help.run();
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("Ungültiger Befehl. Tipp: 'help' eingeben.");
        }
    }
}
