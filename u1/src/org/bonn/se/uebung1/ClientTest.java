package org.bonn.se.uebung1;

/**
 * Executable Client Black Box Test.
 */
public class ClientTest {
    private static final String[] expectedTranslations = {
            "eins",
            "zwei",
            "drei",
            "vier",
            "fünf",
            "sechs",
            "sieben",
            "acht",
            "neun",
            "zehn"
    };

    private static final int[] invalidNumbers = {0, 11, -1};

    // Build client with ClientBuilder
    private static final Client client = ClientBuilder.build(new GermanTranslator());
//    private static final Client client = new InheritedClient(new GermanTranslator());
//    private static final Client client = new DefaultClient();

    public static void main(String[] args) {
        run();
    }

    public static void run() {

        // The test passes by default for valid numbers
        boolean passed = true;

        // Test all valid numbers by expecting them to return an expected translation
        for (int i = 1; i <= expectedTranslations.length; i++) {
            String translation = client.execute(i);
            String expectedTranslation = expectedTranslations[i - 1];

            // Set validNumbersPassed to false if an expectation fails
            if (!translation.equals(expectedTranslation)) {
                passed = false;
            }

            System.out.println("Number: " + i + " | Expected: " + expectedTranslation + " | Actual: " + translation);
        }

        for (int invalidNumber : invalidNumbers) {
            boolean invalidNumberPassed = testInvalidNumber(invalidNumber);

            if (!invalidNumberPassed) {
                passed = false;
            }

            System.out.println("Number: " + invalidNumber + " | Expected: Exception | Actual: " +
                    (invalidNumberPassed ? "Exception" : "No Exception"));
        }

        if (passed) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    /**
     * Tests an invalid number
     * @param number Number to test
     * @return If the number passed the test
     */
    private static boolean testInvalidNumber(int number) {
        try {
            client.execute(0);
            return false; // If this code is reached then no exception was thrown, so the test has to fail
        } catch (IllegalArgumentException ex) {
            return true;
        }
    }
}
