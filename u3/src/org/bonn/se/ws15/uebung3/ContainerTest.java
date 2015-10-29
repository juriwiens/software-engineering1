package org.bonn.se.ws15.uebung3;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.bonn.se.ws15.uebung3.TestUtil.*;

/**
 * Executable Container Test.
 */
public class ContainerTest extends ExecutableTest {
    /**
     * Container instance that will be used for all tests.
     */
    final static Container container = Container.getInstance(Modus.ARRAY_LIST);

    public static void main(String[] args) {
        testSaveAndSize();
        testContainsID();
        testDelete();
        testDump();
        testGetInstance();
        testResetAndGetListType();
        testChangeListType();
        summary();
    }

    public static void testSaveAndSize() {
        Throwable unexpectedException, expectedException;
        int memberIDCounter = 0;

        // Test with all modes
        for (Modus modus : Modus.values()) {
            // Clear the container's state
            container.reset(modus);

            // Container is empty so expect size to be 0
            expectToEqual(container.size(), "size of empty container in modus " + modus, 0, null);

            // Save one Member object and expect size to be 1
            final ClonableMember memberObj = new ClonableMember(++memberIDCounter, Integer.toString(memberIDCounter)); // Save to variable so we can use it later
            unexpectedException = null;
            try {
                container.save(memberObj);
            } catch (Throwable ex) {
                unexpectedException = ex;
            }
            expectToEqual(container.size(), "size of container after saving first object in modus " + modus, 1, unexpectedException);

            // Save four more objects and expect size to be 5
            unexpectedException = null;
            try {
                container.save(new ClonableMember(++memberIDCounter, Integer.toString(memberIDCounter)));
                container.save(new ClonableMember(++memberIDCounter, Integer.toString(memberIDCounter)));
                container.save(new ClonableMember(++memberIDCounter, Integer.toString(memberIDCounter)));
                container.save(new ClonableMember(++memberIDCounter, Integer.toString(memberIDCounter)));
            } catch (Throwable ex) {
                unexpectedException = ex;
            }
            expectToEqual(container.size(), "size of container after saving four more objects in modus " + modus, 5, unexpectedException);

            // Try to save an object with an ID that was already used and expect save() to throw a ContainerException
            unexpectedException = null;
            expectedException = null;
            try {
                container.save(new ClonableMember(memberIDCounter, Integer.toString(memberIDCounter)));
            } catch (ContainerException ex) {
                expectedException = ex;
            } catch (Throwable ex) {
                unexpectedException = ex;
            }
            expectToThrow("saving an object with an already used ID in modus " + modus, ContainerException.class, expectedException,
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
            expectToThrow("saving a cloned object in modus " + modus, ContainerException.class, expectedException,
                    unexpectedException);

            // Try to save an object that does not implement the Info interface and expect it to throw an
            // IllegalArgumentException
            unexpectedException = null;
            expectedException = null;
            final Member memberButNotInfo = new Member() {
                @Override
                public Integer getID() {
                    return null;
                }
            };
            try {
                container.save(memberButNotInfo);
            } catch (IllegalArgumentException ex) {
                expectedException = ex;
            } catch (Throwable ex) {
                unexpectedException = ex;
            }
            expectToThrow("saving an object that does not implement Info in modus " + modus, IllegalArgumentException.class,
                    expectedException, unexpectedException);
        }
    }

    private static void testContainsID() {
        Throwable unexpectedException;

        // Clear the container's state
        container.reset(Modus.ARRAY_LIST);

        // Try to find out if an arbitrary ID exists in an empty container and expect it to return false
        expectToEqual(container.containsID(1), "contains ID 1 in empty container", false, null);

        // Save an object and and expect it to return true
        unexpectedException = null;
        final Integer memberID = 1;
        final Member memberObj = new ClonableMember(memberID, Integer.toString(memberID));
        try {
            container.save(memberObj);
        } catch (Throwable ex) {
            unexpectedException = ex;
        }
        expectToEqual(container.containsID(memberID), "contains ID of saved object", true, unexpectedException);
    }

    private static void testDelete() {
        Throwable unexpectedException;
        final Integer memberID = 1;
        final Member memberObj = new ClonableMember(memberID, Integer.toString(memberID));

        // Clear the container's state
        container.reset(Modus.ARRAY_LIST);

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
        Throwable unexpectedException;
        int memberIDCounter = 0;

        // Clear the container's state
        container.reset(Modus.ARRAY_LIST);

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
                Member obj = new ClonableMember(memberIDCounter, Integer.toString(memberIDCounter));
                container.save(obj);
                expectedDumps.add(obj.toString());
            }
        } catch (Throwable ex) {
            unexpectedException = ex;
        }
        expectToEqual(container.dump(nullOut), "dumped list of 5 members", expectedDumps, unexpectedException);
    }

    public static void testGetInstance() {
        // Expect getInstance() to return the same instance if called twice
        final Container container1 = Container.getInstance(Modus.ARRAY_LIST);
        final Container container2 = Container.getInstance(Modus.ARRAY_LIST);
        expectToEqual(container1 == container2, "comparing two instance references", true, null);
    }

    public static void testResetAndGetListType() {
        Throwable unexpectedException;

        // After resetting to ARRAY_LIST Modus, expect the internal list's type to be ArrayList and to be empty
        container.reset(Modus.ARRAY_LIST); // Clear the container's state
        unexpectedException = null;
        try {
            container.save(new ClonableMember(1, "Test"));
        } catch (Throwable ex) {
            unexpectedException = ex;
        }
        container.reset(Modus.ARRAY_LIST);
        expectToEqual(container.getListType(), "list type after resetting to ARRAY_LIST modus", ArrayList.class, unexpectedException);
        expectToEqual(container.size(), "size after resetting to ARRAY_LIST modus", 0, unexpectedException);

        // After resetting to LINKED_LIST Modus, expect the internal list's type to be LinkedList and to be empty
        container.reset(Modus.ARRAY_LIST); // Clear the container's state
        unexpectedException = null;
        try {
            container.save(new ClonableMember(1, "Test"));
        } catch (Throwable ex) {
            unexpectedException = ex;
        }
        container.reset(Modus.LINKED_LIST);
        expectToEqual(container.getListType(), "list type after resetting to LINKED_LIST modus", LinkedList.class, unexpectedException);
        expectToEqual(container.size(), "size after resetting to LINKED_LIST modus", 0, unexpectedException);

        // After resetting to CUSTOM_LIST Modus, expect the internal list's type to be CustomList and to be empty
        container.reset(Modus.ARRAY_LIST); // Clear the container's state
        unexpectedException = null;
        try {
            container.save(new ClonableMember(1, "Test"));
        } catch (Throwable ex) {
            unexpectedException = ex;
        }
        container.reset(Modus.CUSTOM_LIST);
        expectToEqual(container.getListType(), "list type after resetting to CUSTOM_LIST modus", CustomList.class, unexpectedException);
        expectToEqual(container.size(), "size after resetting to CUSTOM_LIST modus", 0, unexpectedException);
    }

    public static void testChangeListType() {
        Throwable unexpectedException;

        // After changing to ARRAY_LIST Modus, expect the internal list's type to be ArrayList and to be empty
        container.reset(Modus.ARRAY_LIST); // Clear the container's state
        unexpectedException = null;
        try {
            container.save(new ClonableMember(1, "Test"));
        } catch (Throwable ex) {
            unexpectedException = ex;
        }
        container.changeListType(Modus.ARRAY_LIST);
        expectToEqual(container.getListType(), "list type after changing list type to ARRAY_LIST modus", ArrayList.class, unexpectedException);
        expectToEqual(container.size(), "size after changing list type to ARRAY_LIST modus", 0, unexpectedException);

        // After changing to LINKED_LIST Modus, expect the internal list's type to be LinkedList and to be empty
        container.reset(Modus.ARRAY_LIST); // Clear the container's state
        unexpectedException = null;
        try {
            container.save(new ClonableMember(1, "Test"));
        } catch (Throwable ex) {
            unexpectedException = ex;
        }
        container.changeListType(Modus.LINKED_LIST);
        expectToEqual(container.getListType(), "list type after changing list type to LINKED_LIST modus", LinkedList.class, unexpectedException);
        expectToEqual(container.size(), "size after changing list type to LINKED_LIST modus", 0, unexpectedException);

        // After changing to CUSTOM_LIST Modus, expect the internal list's type to be CustomList BUT to keep all saved elements
        container.reset(Modus.ARRAY_LIST); // Clear the container's state
        unexpectedException = null;
        try {
            container.save(new ClonableMember(1, "Test"));
            container.save(new ClonableMember(2, "Test"));
        } catch (Throwable ex) {
            unexpectedException = ex;
        }
        container.changeListType(Modus.CUSTOM_LIST);
        expectToEqual(container.getListType(), "list type after changing list type to CUSTOM_LIST modus", CustomList.class, unexpectedException);
        expectToEqual(container.size(), "size after changing list type to CUSTOM_LIST modus", 2, unexpectedException);
        expectToEqual(container.containsID(1), "still containing ID 1 after changing list type to CUSTOM_LIST modus", true, unexpectedException);
        expectToEqual(container.containsID(2), "still containing ID 2 after changing list type to CUSTOM_LIST modus", true, unexpectedException);
    }
}