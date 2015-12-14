package org.bonn.se.ws15.uebung9;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class ComplexDocument implements DocumentComponent {
    private int id;
    private List<DocumentComponent> subComponents;

    public ComplexDocument(List<DocumentComponent> subComponents) {
        this.subComponents = subComponents;
    }

    public boolean addSubComp(DocumentComponent doc) {
        return subComponents.add(doc);
    }

    public boolean removeSubComp(DocumentComponent doc) {
        return subComponents.remove(doc);
    }

    public int subCompSize() {
        return subComponents.size();
    }

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
    public int getByteSize() throws UnsupportedEncodingException {
        int byteSize = 0;

        for (DocumentComponent subComp : subComponents) {
            byteSize += subComp.getByteSize();
        }

        return byteSize;
    }
}
