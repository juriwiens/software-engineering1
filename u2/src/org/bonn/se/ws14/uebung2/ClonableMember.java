package org.bonn.se.ws14.uebung2;

public class ClonableMember implements Member, Cloneable {
    private final Integer id;

    public ClonableMember(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getID() {
        return id;
    }

    /**
     * Clones this member.
     * @return Cloned member
     */
    public ClonableMember clone() {
        return new ClonableMember(id);
    }

   @Override
    public String toString() {
        return getID().toString();
    }
}
