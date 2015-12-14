package org.bonn.se.ws15.uebung9.test;

import org.bonn.se.ws15.uebung9.TextDocument;

import static org.bonn.se.ws15.uebung9.test.ExecutableTest.expectToEqual;

public class TextDocumentTest implements Test {
    public void providesInnerEncodingEnum() {
        expectToEqual(TextDocument.Encoding.values().length, "TextDoc's inner Encoding enum size", 3, null);
    }

    public void returnsByteSizeConsideringEncoding() {
        int byteSize = 0;
        Exception unexpectedException = null;

        final TextDocument doc = new TextDocument("TestStr", TextDocument.Encoding.UTF8);

        // Test UTF8
        try {
            byteSize = doc.getByteSize();
        } catch (Exception e) {
            unexpectedException = e;
        }
        expectToEqual(byteSize, "TextDoc's UTF8 byteSize", 7, unexpectedException);

        // Test UTF16
        try {
            byteSize = doc.getByteSize();
        } catch (Exception e) {
            unexpectedException = e;
        }
        expectToEqual(byteSize, "TextDoc's UTF16 byteSize", 7, unexpectedException);

        // Test UTF32
        try {
            byteSize = doc.getByteSize();
        } catch (Exception e) {
            unexpectedException = e;
        }
        expectToEqual(byteSize, "TextDoc's UTF32 byteSize", 7, unexpectedException);
    }

    @Override
    public void executeTests() {
        providesInnerEncodingEnum();
        returnsByteSizeConsideringEncoding();
    }
}
