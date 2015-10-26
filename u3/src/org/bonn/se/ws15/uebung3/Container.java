package org.bonn.se.ws15.uebung3;

import java.io.PrintStream;
import java.util.*;

public class Container {
    /**
     * Singleton instance.
     */
    private static Container instance;

    /**
     * List used as internal memory.
     */
    private List<Member> list;

    /**
     * Private constructor because of Singleton pattern.
     *
     * @param modus List type modus
     */
    private Container(Modus modus) throws IllegalArgumentException {
        reset(modus); // Use reset to init list
    }

    /**
     * Creates and returns only one instance for this class (Singleton). Non thread safe variant!
     *
     * @param modus List type modus
     * @return The only Container instances
     */
    public static Container getInstance(Modus modus) throws IllegalArgumentException {
        if (Container.instance == null) {
            Container.instance = new Container(modus);
        }
        return Container.instance;
    }

    /**
     * Saves a Member object.
     *
     * @param obj Member object to save
     * @throws ContainerException when it already contains an object with this ID
     */
    public void save(Member obj) throws ContainerException, IllegalArgumentException {
        // Check if obj also implements Info
        if (!(obj instanceof Info)) {
            throw new IllegalArgumentException("Das Member-Objekt implementiert Info nicht.");
        }

        final Integer id = obj.getID();

        if (!containsID(id)) {
            list.add(obj);
        } else {
            throw new ContainerException(obj);
        }
    }

    /**
     * Deletes a Member object.
     *
     * @param obj Member object to delete
     * @return Result message
     */
    public String delete(Member obj) {
        final Integer id = obj.getID();

        if (containsID(id)) {
            list.remove(obj);
            return "Das Member-Objekt mit der ID " + id + " wurde erfolgreich gelöscht.";
        } else {
            return "Das Member-Objekt mit der ID " + id + " ist nicht vorhanden.";
        }
    }

    /**
     * Dumps the contained member objects by returning their String representations to a PrintStream (like System.out)
     * and as a return value for testing purposes.
     *
     * @return Sorted list of string representations
     */
    public List<String> dump(PrintStream out) {
        final List<String> strList = new ArrayList<String>();

        out.printf("Container Dump: ");
        for (Member obj : list) {
            strList.add(obj.toString());
            out.print(obj.toString() + " ");
        }

        return strList;
    }

    /**
     * Returns the number of contained Member objects.
     *
     * @return number of contained objects
     */
    public int size() {
        return list.size();
    }

    /**
     * Checks if this container already contains the id.
     *
     * @param id ID to check
     * @return boolean
     */
    public boolean containsID(Integer id) {
        for (Member obj : list) {
            if (obj.getID().equals(id)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the internal list's type. Useful for testing purposes.
     *
     * @return List Class
     */
    public Class getListType() {
        return list.getClass();
    }

    /**
     * Resets the internal list of a type depending on modus.
     *
     * @param modus List modus
     */
    public void reset(Modus modus) throws IllegalArgumentException {
        switch (modus) {
            case ARRAY_LIST:
                list = new ArrayList<Member>();
                break;
            case LINKED_LIST:
                list = new LinkedList<Member>();
                break;
            case CUSTOM_LIST:
                // Wrap a new ArrayList into CustomList
                list = new CustomList<Member>(new ArrayList());
                break;
            default:
                throw new IllegalArgumentException("Nicht implementierter Modus.");
        }
    }

    /**
     * Changes list type depending on modus.
     *
     * @param modus List modus
     */
    public void changeListType(Modus modus) throws IllegalArgumentException {
        switch (modus) {
            case ARRAY_LIST:
                // Changing to ARRAY_LIST modus resets the list
                reset(Modus.ARRAY_LIST);
                break;
            case LINKED_LIST:
                // Changing to LINKED_LIST modus resets the list
                reset(Modus.LINKED_LIST);
                break;
            case CUSTOM_LIST:
                // Changing to CUSTOM_LIST modus wraps existing list into CustomList to keep all saved elements
                list = new CustomList<Member>(list);
                break;
            default:
                throw new IllegalArgumentException("Nicht implementierter Modus.");
        }
    }
}

enum Modus {
    ARRAY_LIST, LINKED_LIST, CUSTOM_LIST
}