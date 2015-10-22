package org.bonn.se.ws14.uebung2;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.bonn.se.ws14.uebung2.TestUtil.expectToEqual;
import static org.bonn.se.ws14.uebung2.TestUtil.expectToThrow;
import static org.bonn.se.ws14.uebung2.TestUtil.nullPrintStream;

/**
 * Executable Container Test.
 */
public class ContainerTest {
    public static void main(String[] args) {
        testSaveAndSize();
        testContainsID();
        testDelete();
        testDump();
    }

    public static void testSaveAndSize() {
        final Container container = new Container(new HashMap<Integer, Member>());
        Throwable unexpectedException, expectedException;
        int memberIDCounter = 0;

        // Container is empty so expect size to be 0
        expectToEqual(container.size(), "size of empty container", 0, null);

        // Save one Member object and expect size to be 1
        final ClonableMember memberObj = new ClonableMember(++memberIDCounter); // Save to variable so we can use it later
        unexpectedException = null;
        try {
            container.save(memberObj);
        } catch (Throwable ex) {
            unexpectedException = ex;
        }
        expectToEqual(container.size(), "size of container after saving first object", 1, unexpectedException);

        // Save four more objects and expect size to be 5
        unexpectedException = null;
        try {
            container.save(new ClonableMember(++memberIDCounter));
            container.save(new ClonableMember(++memberIDCounter));
            container.save(new ClonableMember(++memberIDCounter));
            container.save(new ClonableMember(++memberIDCounter));
        } catch (Throwable ex) {
            unexpectedException = ex;
        }
        expectToEqual(container.size(), "size of container after saving four more objects", 5, unexpectedException);

        // Try to save an object with an ID that was already used and expect save() to throw a ContainerException
        unexpectedException = null;
        expectedException = null;
        try {
            container.save(new ClonableMember(memberIDCounter));
        } catch (ContainerException ex) {
            expectedException = ex;
        } catch (Throwable ex) {
            unexpectedException = ex;
        }
        expectToThrow("saving an object with an already used ID", ContainerException.class, expectedException,
                unexpectedException);

        // Try to save() a cloned object and expect it to throw a ContainerException
        unexpectedException = null;
        expectedException = null;
        final Member clonedObj = memberObj.clone();
        try {
            container.save(clonedObj);
        } catch (ContainerException ex) {
            expectedException = ex;
        } catch (Throwable ex) {
            unexpectedException = ex;
        }
        expectToThrow("saving a cloned object", ContainerException.class, expectedException,
                unexpectedException);
    }

    private static void testContainsID() {
        final Container container = new Container(new HashMap<Integer, Member>());
        Throwable unexpectedException;

        // Try to find out if an arbitrary ID exists in an empty container and expect it to return false
        expectToEqual(container.containsID(1), "contains ID 1 in empty container", false, null);

        // Save an object and and expect it to return true
        unexpectedException = null;
        final Integer memberID = 1;
        final Member memberObj = new ClonableMember(memberID);
        try {
            container.save(memberObj);
        } catch (Throwable ex) {
            unexpectedException = ex;
        }
        expectToEqual(container.containsID(memberID), "contains ID of saved object", true, unexpectedException);
    }

    private static void testDelete() {
        final Container container = new Container(new HashMap<Integer, Member>());
        Throwable unexpectedException;
        final Integer memberID = 1;
        final Member memberObj = new ClonableMember(memberID);

        // Try to delete a Member object from an empty container and expect it to return a specific error message
        {
            final String expectedMsg = "Das Member-Objekt mit der ID " + memberID + " ist nicht vorhanden.";
            expectToEqual(container.delete(memberObj), "message for deleting an object from an empty container",
                    expectedMsg, null);
        }

        // Save a Member object and expect it to return a specific success message
        {
            unexpectedException = null;
            final String expectedMsg = "Das Member-Objekt mit der ID " + memberID + " wurde erfolgreich gelöscht.";
            try {
                container.save(memberObj);
            } catch (Throwable ex) {
                unexpectedException = ex;
            }
            expectToEqual(container.delete(memberObj), "message for deleting a saved object", expectedMsg,
                    unexpectedException);
        }
    }

    private static void testDump() {
        final Container container = new Container(new HashMap<Integer, Member>());
        Throwable unexpectedException;
        int memberIDCounter = 0;

        // Use a PrintStream that just throws away all messages to keep test output clean
        final PrintStream nullOut = nullPrintStream();

        // Dump an empty container and expect it to return an empty list of ID Strings
        expectToEqual(container.dump(nullOut).isEmpty(), "checking emptiness of a dump list for an empty container", true,
                null);

        // Save 5 objects and expect it to return a set of dumps
        unexpectedException = null;
        final List<String> expectedDumps = new ArrayList<String>();
        try {
            while (memberIDCounter <= 5) {
                ++memberIDCounter;
                Member obj = new ClonableMember(memberIDCounter);
                container.save(obj);
                expectedDumps.add(obj.toString());
            }
        } catch (Throwable ex) {
            unexpectedException = ex;
        }
        expectToEqual(container.dump(nullOut), "dumped list of 5 members", expectedDumps, unexpectedException);
    }
}
