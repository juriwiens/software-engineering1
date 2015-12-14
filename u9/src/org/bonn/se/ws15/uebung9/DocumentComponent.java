package org.bonn.se.ws15.uebung9;

import java.io.UnsupportedEncodingException;

public interface DocumentComponent {
    int getID();
    void setID(int id);
    int getByteSize() throws UnsupportedEncodingException;
}
