package org.bonn.se.ws15.uebung8.commands;

import java.io.IOException;

public interface Command {
    String getDescription();

    void execute() throws IOException;
}
