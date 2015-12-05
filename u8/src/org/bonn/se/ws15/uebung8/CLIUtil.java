package org.bonn.se.ws15.uebung8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLIUtil {
    public static <T> T askFor(String what, FromStringBuilder<T> builder) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input;
        T result = null;

        do {
            System.out.print(what + ": ");
            input = in.readLine();

            try {
                result = builder.fromString(input);
            } catch (IllegalArgumentException ex) {
                System.out.println("FEHLER: " + ex.getMessage());
            }
        } while (result == null);

        return result;
    }
}
