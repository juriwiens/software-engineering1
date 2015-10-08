package org.bonn.se.uebung1;

class Client {
    /**
     * Translator instance
     */
    private Translator translator;

    public Client(Translator translator) {
        this.translator = translator;
    }

    /**
     * Executes client
     *
     * The original function returned nothing (void). Changed this to return the translated number in order to make it
     * testable!
     *
     * @param aNumber A Number
     * @return Translated number
     */
    public String execute(int aNumber) {
        // In dieser Methode soll die Methode translateNumber mit dem
        // übergegebenen Wert der Variable aNumber aufgerufen werde
        final String translation = translator.translateNumber(aNumber);
        System.out.println("Das Ergebnis der Berechnung: " + translation);

        return translation; // See doc comment
    }

}