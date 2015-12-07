package org.bonn.se.ws15.uebung8.views;

import org.bonn.se.ws15.uebung8.controllers.CmdEvaluator;

import java.io.*;

public class CmdPromptView {
    private final CmdEvaluator cmdEvaluator;
    private final InputStream in;
    private final PrintStream out;
    private final PrintStream err;

    public CmdPromptView(CmdEvaluator cmdEvaluator, InputStream in, PrintStream out, PrintStream err) {
        this.cmdEvaluator = cmdEvaluator;
        this.in = in;
        this.out = out;
        this.err = err;
    }

    public void prompt() {
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(this.in));
        String s;

        //noinspection InfiniteLoopStatement
        while (true) {
            out.print("UserStoryCLI > ");
            try {
                s = bufIn.readLine();
                cmdEvaluator.eval(s);
            } catch (IOException e) {
                err.println("Kommandoauswertung fehlgeschlagen!");
                System.exit(1);
            }
        }
    }
}
