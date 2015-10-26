package org.bonn.se.ws15.uebung3;

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
     *
     * One way to implement this function would be to all call clone methods in the class hierarchy up to Object and
     * to set all class specific properties afterwards (see commented-out code). This leads to ugly code IMHO. So I
     * decided to not use this variant, because then I would have to implement setID() and id could not be final
     * anymore. Furthermore it is considered best practice to avoid this way cloning due to many comments on
     * stackoverflow.com.
     *
     * @return Cloned member
     */
    public ClonableMember clone() {
//        ClonableMember cloned = null;
//
//        try {
//            cloned = (ClonableMember) super.clone();
//        } catch (CloneNotSupportedException ex) {
//            // Just ignore this exception, because we know for sure that Object is clonable
//        }
//
//        cloned.setID(id);
//
//        return cloned;

        // Use a simple and short solution
        return new ClonableMember(id);
    }

   @Override
    public String toString() {
        return getID().toString();
    }
}
