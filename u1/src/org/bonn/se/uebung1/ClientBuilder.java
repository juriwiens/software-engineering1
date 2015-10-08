package org.bonn.se.uebung1;

/**
 * Builds a Clients by injecting it's dependencies
 */
public class ClientBuilder {

    /**
     * Builds a Client
     * @param translator Translator dependency
     * @return New Client instance
     */
    public static Client build(Translator translator) {
        return new Client(translator);
    }
}
