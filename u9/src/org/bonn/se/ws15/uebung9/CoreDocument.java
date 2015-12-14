package org.bonn.se.ws15.uebung9;

import java.io.UnsupportedEncodingException;

public abstract class CoreDocument implements DocumentComponent {
    private int id;

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
        LogUtil.logRegistration(id, this.getClass());
    }

    @Override
    public abstract int getByteSize() throws UnsupportedEncodingException;
}
