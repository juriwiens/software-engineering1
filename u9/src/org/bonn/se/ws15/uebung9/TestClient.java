package org.bonn.se.ws15.uebung9;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class TestClient {
    public static void main(String[] args) throws UnsupportedEncodingException {
        final ComplexDocument doc0 = new ComplexDocument(new ArrayList<DocumentComponent>());
        doc0.setID(0);

        final DocumentComponent doc2 = new TextDocument("Die Klausur im Fach SE findet bald statt!",
                TextDocument.Encoding.UTF8);
        doc2.setID(2);
        doc0.addSubComp(doc2);

        final ComplexDocument doc3 = new ComplexDocument(new ArrayList<DocumentComponent>());
        doc3.setID(3);
        doc0.addSubComp(doc3);

        final DocumentComponent doc4 = new GraphicDocument("localhost:8080");
        doc4.setID(4);
        doc3.addSubComp(doc4);

        final DocumentComponent doc5 = new TextDocument("Software Engineering I ist eine Vorlesung in den Studiengaengen BIS und BCS", TextDocument.Encoding.UTF32);
        doc5.setID(5);
        doc3.addSubComp(doc5);

        System.out.printf("doc0 byteSize: %d | expected: %d%n", doc0.getByteSize(), 1200 + 300 + 41);
        System.out.printf("doc2 byteSize: %d | expected: %d%n", doc2.getByteSize(), 41);
        System.out.printf("doc3 byteSize: %d | expected: %d%n", doc3.getByteSize(), 1200 + 300);
        System.out.printf("doc4 byteSize: %d | expected: %d%n", doc4.getByteSize(), 1200);
        System.out.printf("doc5 byteSize: %d | expected: %d%n", doc5.getByteSize(), 300);
    }
}
