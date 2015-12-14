package org.bonn.se.ws15.uebung9;

public class GraphicDocument extends CoreDocument {
    private String url;

    public GraphicDocument(String url) {
        this.url = url;
    }

    @Override
    public int getByteSize() {
        return 1200;
    }
}
