package org.bonn.se.ws15.uebung9.test;

public class TestRunner extends ExecutableTest {
    public static void main(String[] args) {
        new TextDocumentTest().executeTests();
        new ComplexDocumentTest().executeTests();

        summary();
    }
}
