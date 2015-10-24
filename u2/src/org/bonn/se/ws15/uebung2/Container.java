package org.bonn.se.ws15.uebung2;

import java.io.PrintStream;
import java.util.*;

public class Container {
    /**
     * HashMap used as memory.
     */
    private final List<Member> list;

    public Container(List<Member> list) {
        this.list = list;
    }

    /**
     * Saves a Member object.
     * @param obj Member object to save
     * @throws ContainerException when it already contains an object with this ID
     */
    public void save(Member obj) throws ContainerException {
        final Integer id = obj.getID();

        if (!containsID(id)) {
            list.add(obj);
        } else {
            throw new ContainerException(obj);
        }
    }

    /**
     * Deletes a Member object.
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
     * @return number of contained objects
     */
    public int size() {
        return list.size();
    }

    /**
     * Checks if this container already contains the id.
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
}
