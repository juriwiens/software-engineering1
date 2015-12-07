package org.bonn.se.ws15.uebung8.utilities;

import org.bonn.se.ws15.uebung8.models.FromStringBuilder;

import java.io.*;

public class CLIUtil {
    public static <T> T askFor(String what, FromStringBuilder<T> builder, InputStream in, PrintStream out) throws IOException {
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(in));
        String input;
        T result = null;

        do {
            out.print(what + ": ");
            input = bufIn.readLine();

            try {
                result = builder.fromString(input);
            } catch (IllegalArgumentException ex) {
                out.println("FEHLER: " + ex.getMessage());
            }
        } while (result == null);

        return result;
    }
}
