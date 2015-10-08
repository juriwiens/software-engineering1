package org.bonn.se.uebung1;

/**
 * Client with an instance of GermanTranslator as default Translator.
 */
public class DefaultClient extends Client {
    public DefaultClient() {
        super(new GermanTranslator());
    }
}
