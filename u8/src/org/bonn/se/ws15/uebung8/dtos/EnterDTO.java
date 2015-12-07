package org.bonn.se.ws15.uebung8.dtos;

public class EnterDTO {
    private final String cmdDescription;

    public String getCmdDescription() {
        return cmdDescription;
    }

    public EnterDTO(String cmdDescription) {
        this.cmdDescription = cmdDescription;
    }
}
