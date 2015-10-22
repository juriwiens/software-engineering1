package org.bonn.se.ws14.uebung2;

import java.io.PrintStream;
import java.util.*;

public class Container {
    /**
     * HashMap used as memory.
     */
    private final HashMap<Integer, Member> map;

    public Container(HashMap<Integer, Member> map) {
        this.map = map;
    }

    /**
     * Saves a Member object.
     * @param obj Member object to save
     * @throws ContainerException when it already contains an object with this ID
     */
    public void save(Member obj) throws ContainerException {
        final Integer id = obj.getID();

        if (!containsID(id)) {
            map.put(id, obj);
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
            map.remove(id);
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

        // Get keys as a sorted list
        final Collection<Member> objs = map.values();

        out.printf("Container Dump: ");
        for (Member obj : objs) {
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
        return map.size();
    }

    /**
     * Checks if this container already contains the id.
     * @param id ID to check
     * @return boolean
     */
    public boolean containsID(Integer id) {
        return map.containsKey(id);
    }
}
