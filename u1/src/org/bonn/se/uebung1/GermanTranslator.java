package org.bonn.se.uebung1;

public class GermanTranslator implements Translator {

    /**
     * Contains the number's translations
     * Key n contains translation for n+1, so you will have to use number-1 as key to get the correct result
     */
    private final String[] translations = {
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

    @Override
    public String translateNumber(int number) {
        try {
            return translations[number-1];
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("Übersetzung der Zahl" + number + "nicht möglich (" + version + ")");
        }
    }

    public void printAuthorInfo() {
        System.out.println("GermanTranslator c/o 2015 by HBRS");
    }

}
