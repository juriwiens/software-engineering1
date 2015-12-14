package org.bonn.se.ws15.uebung9.test;

import org.bonn.se.ws15.uebung9.ComplexDocument;
import org.bonn.se.ws15.uebung9.DocumentComponent;
import org.bonn.se.ws15.uebung9.GraphicDocument;
import org.bonn.se.ws15.uebung9.TextDocument;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import static org.bonn.se.ws15.uebung9.test.ExecutableTest.expectToEqual;

public class ComplexDocumentTest implements Test {
    public void canContainAnyNumberOfDocs() {
        final ComplexDocument cDoc = new ComplexDocument(new ArrayList<DocumentComponent>());

        cDoc.addSubComp(new TextDocument("testStr", TextDocument.Encoding.UTF8));
        cDoc.addSubComp(new GraphicDocument("testURL"));
        expectToEqual(cDoc.subCompSize(), "ComplexDoc's subCompSize after adding 2 CoreDocs", 2, null);

        final ComplexDocument cDoc2 = new ComplexDocument(new ArrayList<DocumentComponent>());
        cDoc2.addSubComp(new TextDocument("testStr2", TextDocument.Encoding.UTF16));
        cDoc.addSubComp(cDoc2);
        expectToEqual(cDoc.subCompSize(), "ComplexDoc's subCompSize after adding another ComplexDoc", 3, null);
    }

    public void subCompsCanBeDeleted() {
        final ComplexDocument cDoc = new ComplexDocument(new ArrayList<DocumentComponent>());
        final DocumentComponent tDoc = new TextDocument("testStr", TextDocument.Encoding.UTF8);
        cDoc.addSubComp(tDoc);
        cDoc.removeSubComp(tDoc);
        expectToEqual(cDoc.subCompSize(), "ComplexDoc's subCompsize after adding and removing a comp", 0, null);
    }

    @Override
    public void executeTests() {
        canContainAnyNumberOfDocs();
        subCompsCanBeDeleted();
    }
}
