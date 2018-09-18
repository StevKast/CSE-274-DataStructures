//Steven Kast, kastsm

package program1_PalBook;

import java.util.ArrayList;

public class Member implements Comparable<Member> {

    private ArrayList<Member> pals;
    private String name;

    /**
     * Constructs a member object with a name and list of pals
     * @param name Name(or id) of a member
     */
    public Member(String name){
        this.name = name;
        pals = new ArrayList();
    }

    /**
     * Adds a pal to the palList
     * @param pal member object to be added
     */
    public void addPal(Member pal){
        if(!(pals.contains(pal))) {
        	pals.add(pal);
        }
    }

    /**
     * Removes a pal for the palList
     * @param pal member to be removed
     */
    public void removePal(Member pal){
        pals.remove(pal);
    }

    /**
     * Check if a member is a pal
     * @param pal pal to check
     * @return returns true if member is a pal, false otherwise
     */
    public boolean isPal(Member pal){
        return pals.contains(pal);
    }

    /**
     * Returns the name of the member as a string, used as an id
     * @return name of member
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the list of pals
     * @return ArrayList of pals
     */
    public ArrayList<Member> getPals(){
    	return pals;
    }

    /**
     * Returns the member as a nicely formated string
     */
    @Override
    public String toString() {
        return name + " Pals: " + pals.toString();
    }

    /**
     * Compares a member to another member by name
     */
    @Override
    public int compareTo(Member mem) {
        return name.compareTo(mem.getName());
    }
}
