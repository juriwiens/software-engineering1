package org.bonn.se.ws15.uebung8.controllers;

import java.io.IOException;

public interface CmdEvaluator {
    void eval(String cmdStr) throws IOException;
}
