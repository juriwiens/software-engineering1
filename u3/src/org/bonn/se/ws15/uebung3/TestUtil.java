package org.bonn.se.ws15.uebung3;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Test Utilities.
 */
public class TestUtil {
//    public static <T> boolean expectToEqual(T testRes, String testResName, T expectedEqual,
//                                         Throwable unexpectedException) {
//        boolean passed = false;
//        final boolean equals = testRes.equals(expectedEqual);
//
//        if (unexpectedException == null) {
//            passed = equals; // If there is no unexpectedException the test passes on equality
//            System.out.printf("Expected '%s' to equal: '%s', actual: '%s' => %s%n", testResName, expectedEqual, testRes,
//                    equals ? "PASSED" : "FAILED");
//        } else {
//            passed = false; // Test
//            System.out.printf("Expected '%s' to equal: '%s' => FAILED with unexpected Exception: %s%n", testResName, expectedEqual,
//                    unexpectedException.getMessage());
//        }
//
//        return passed;
//    }
//
//    public static <T> boolean expectToThrow(String testResName, Class expectedExceptionClass, T expectedException,
//                                         Throwable unexpectedException) {
//        boolean passed = false;
//
//        if (expectedException != null && unexpectedException == null) {
//            // Test passes only in this case
//            passed = true;
//        }
//
//        System.out.printf("Expected '%s' to throw %s => %s%n", testResName, expectedExceptionClass.getSimpleName(),
//                passed ? "PASSED" : "FAILED");
//
//        return passed;
//    }

    public static PrintStream nullPrintStream() {
        OutputStream nullOutputStream = new OutputStream() { @Override public void write(int b) {} };
        PrintStream nullPrintStream = new PrintStream(nullOutputStream);
        return nullPrintStream;
    }
}
