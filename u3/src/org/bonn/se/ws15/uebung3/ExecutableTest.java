package org.bonn.se.ws15.uebung3;

public abstract class ExecutableTest {
    protected static boolean allTestsPassed = true;

    protected static <T> void expectToEqual(T testRes, String testResName, T expectedEqual,
                                         Throwable unexpectedException) {
        boolean passed = false;
        final boolean equals = testRes.equals(expectedEqual);

        if (unexpectedException == null) {
            passed = equals; // If there is no unexpectedException the test passes on equality
            System.out.printf("Expected '%s' to equal: '%s', actual: '%s' => %s%n", testResName, expectedEqual, testRes,
                    equals ? "PASSED" : "FAILED");
        } else {
            passed = false; // Test
            System.out.printf("Expected '%s' to equal: '%s' => FAILED with unexpected Exception: %s%n", testResName, expectedEqual,
                    unexpectedException.getMessage());
        }

        if (!passed) {
            allTestsPassed = false;
        }
    }

    protected static <T> void expectToThrow(String testResName, Class expectedExceptionClass, T expectedException,
                                         Throwable unexpectedException) {
        boolean passed = false;

        if (expectedException != null && unexpectedException == null) {
            // Test passes only in this case
            passed = true;
        }

        System.out.printf("Expected '%s' to throw %s => %s%n", testResName, expectedExceptionClass.getSimpleName(),
                passed ? "PASSED" : "FAILED");

        if (!passed) {
            allTestsPassed = false;
        }
    }

    protected static void summary() {
        System.out.println(allTestsPassed ?
                "Die gesamte TestSuite war erfolgreich!" :
                "Die TestSuite war nicht erfolgreich!");
    }
}
