package org.bonn.se.ws15.uebung9;

import java.io.UnsupportedEncodingException;

public class TextDocument extends CoreDocument {
    private String text;
    private Encoding encoding;

    public TextDocument(String text, Encoding encoding) {
        this.text = text;
        this.encoding = encoding;
    }

    public enum Encoding { UTF8, UTF16, UTF32 }

    @Override
    public int getByteSize() throws UnsupportedEncodingException {
        return text.getBytes(encoding.toString()).length;
    }
}