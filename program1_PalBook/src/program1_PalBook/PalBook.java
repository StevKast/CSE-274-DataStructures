//Steven Kast, kastsm
//Working: Everything expect membersWithDegree
//Members with degree - it works for the most part but it breaks in a very specific
//case when a member has the same degree with another member but through multiple
//paths.

package program1_PalBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class PalBook {

	private ArrayList<Member> members;
	private int maxNetworkSize;

	/**
	 * Constructs an empty PalBook network with a default capacity of 500 members
	 */
	public PalBook() {
		maxNetworkSize = 500;
		members = new ArrayList(maxNetworkSize);
	}

	/**
	 * Constructs an empty PalBook network with a set capacity
	 * 
	 * @param maxNetworkSize
	 *            Maximum amount of members in the network
	 */
	public PalBook(int maxNetworkSize) {
		this.maxNetworkSize = maxNetworkSize;
		members = new ArrayList(maxNetworkSize);
	}

	/**
	 * Returns the number of members in the network.
	 * 
	 * @return Number of members in the network.
	 */
	public int getMemberCount() {
		return members.size();
	}

	/**
	 * Adds a member to the social network
	 * @param id Member to be added
	 * @return Returns true if successful, false otherwise
	 */
	public boolean addMember(String id) {
		if (getMemberCount() < maxNetworkSize) {
			members.add(new Member(id));
			return true;
		}
		return false;
	}

	/**
	 * Removes a member from the network
	 * @param id id of member to be removed
	 */
	public void removeMember(String id) {
		members.remove(getMember(id));
	}

	/**
	 * Returns true if there exists a member in the network with the given id, and false otherwise.
	 * @param id id of member to check
	 * @return returns true if member exists, false otherwise
	 */
	public boolean containsMember(String id) {
		for (Member mem : members) {
			if (mem.getName().equals(id)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * If id1 and id2 are members in the network, then makes them pals.
	 * @param id1 id of one member
	 * @param id2 id of another member
	 * @return returns true is successful, false otherwise
	 */
	public boolean makePals(String id1, String id2) {
		if (containsMember(id1) && containsMember(id2)) {
			getMember(id1).addPal(getMember(id2));
			getMember(id2).addPal(getMember(id1));
			return true;
		}
		return false;
	}

	/**
	 * Removes id1 from id2's pal list, and removes id2 from id1's pal list.
	 * @param id1 id of one member
	 * @param id2 id of another member
	 */
	public void endPals(String id1, String id2) {
		if (containsMember(id1) && containsMember(id2)) {
			getMember(id1).removePal(getMember(id2));
			getMember(id2).removePal(getMember(id1));
		}
	}

	/**
	 * Returns true if the two specified people exist in the network, and are pals, and returns false otherwise.
	 * @param id1 id of one member
	 * @param id2 id of another member
	 * @return Returns true if 2 members are pals
	 */
	public boolean arePals(String id1, String id2) {
		if (containsMember(id1) && containsMember(id2)) {
			return (getMember(id1).isPal(getMember(id2)) && getMember(id2).isPal(getMember(id1)));
		}
		return false;
	}

	/**
	 * Returns a (possibly empty) array of all members in the network, sorted by id.
	 * @return array of all members in the network
	 */
	public String[] getMembers() {
		Collections.sort(members);
		String[] currentMembers = new String[getMemberCount()];
		for (int i = 0; i < getMemberCount(); i++) {
			currentMembers[i] = members.get(i).getName();
		}
		return currentMembers;
	}

	/**
	 * Gets the member object for a given id string
	 * @param id id of member
	 * @return member object of the given id
	 */
	private Member getMember(String id) {
		for (Member mem : members) {
			if (mem.getName().equals(id)) {
				return mem;
			}
		}
		return null;
	}

	/**
	 * Returns the pals of a particular member, sorted by id.
	 * @param id id of member
	 * @return String array of pals
	 */
	public String[] getPals(String id) {
		ArrayList<Member> pals = getMember(id).getPals();
		Collections.sort(pals);
		String[] stringPals = new String[pals.size()];
		for (int i = 0; i < pals.size(); i++) {
			stringPals[i] = pals.get(i).getName();
		}
		return stringPals;
	}

	/**
	 * Formats network as a string
	 */
	@Override
	public String toString() {
		String str = "";
		String palStr = "";
		Collections.sort(members);
		for (Member mem : members) {
			for (String pal : getPals(mem.getName())) {
				palStr += pal + " ";
			}
			str += "[" + mem.getName() + "] " + palStr + "\n";
			palStr = ""; // Clearing palStr for next iteration.
		}
		return str;
	}

	/**
	 * Given two members, returns an array of members who are pals with both of the
	 * two members. The array will be sorted by the members' ids.
	 * 
	 * @param id1
	 *            the id of one member
	 * @param id2
	 *            the id of another (not necessarily different) member
	 * @return
	 */
	public String[] commonPals(String id1, String id2) {
		ArrayList<String> commonPals = new ArrayList<>();
		for (Member pal1 : getMember(id1).getPals()) {
			for (Member pal2 : getMember(id2).getPals()) {
				if (arePals(pal1.getName(), pal2.getName())) {
					commonPals.add(pal2.getName());
				}
			}
		}
		Collections.sort(commonPals);
		return commonPals.toArray(new String[commonPals.size()]);
	}

	/**
	 * Returns an array of all members who are "pals of pals" of a specified member,
	 * but are not pals with that member. In other words, returns an array of all
	 * members who are exactly two degrees of separation from a specified member.
	 * Returns an empty array (length 0) if no members exist who are two degrees of
	 * separation from the given member. The array will be sorted by the members'
	 * ids.
	 * 
	 * @param id
	 *            the id of the specified member
	 * @return an array of members with two degrees of separation from the specified
	 *         member, sorted by id.
	 */
	public String[] getPalsOfPals(String id) {
		ArrayList<String> palsOfPals = new ArrayList<>();
		for (Member pal1st : getMember(id).getPals()) {
			palsOfPals.addAll(Arrays.asList(getPals(pal1st.getName())));
		}
		Collections.sort(palsOfPals);
		return palsOfPals.toArray(new String[palsOfPals.size()]);
	}

	/**
	 * Returns the degrees of separation between two (not necessarily distinct)
	 * members. Returns -1 if there is no way to get to one member from another
	 * through a chain of pals
	 * 
	 * @param id1
	 *            The id of the first member
	 * @param id2
	 *            The id of the second member
	 * @return The number of degrees of separation between id1 and id2, -1 if not
	 *         connected.
	 */
	public int degreesOfSeparation(String id1, String id2) {
		ArrayList<Member> listA = new ArrayList();
		ArrayList<Member> listB = new ArrayList();
		int deg = 0;

		Member goal = getMember(id2);

		listA.add(getMember(id1));

		while(!listA.isEmpty()) {

			//System.out.println(listA.toString());
			for (int i = 0; i < listA.size(); i++) {
				if (listA.get(i).equals(goal)) {
					return deg;
				} else {
					listB.add(listA.get(i));
				}
			}
			deg++;
			for(int k = 0; k < listB.size(); k++) {
				listA.addAll(listB.get(k).getPals());
				listA.removeAll(listB);
			}
		}
		return -1;
	}

	/**
	 * Returns an array of all members with a given number of degrees of separation from a specified member.
	 * @param id1 id of member
	 * @param degrees how many degrees away from id1 to find
	 * @return String array of members with degrees
	 */
	public String[] membersWithDegree(String id1, int degrees) {
		ArrayList<String> stack1 = new ArrayList(); //Placeholder ArrayList
		ArrayList<String> stack2 = new ArrayList();

		if(degreesOfSeparation(id1, id1) == degrees) {
			stack2.add(id1);
			return stack2.toArray(new String[stack2.size()]);
		} else {
			for(Member pal: getMember(id1).getPals()) {
				if(degreesOfSeparation(pal.getName(), id1) == degrees) {
					stack2.add(pal.getName());
				}else{
					//System.out.println("RECURSION call");
					stack1.add(pal.getName());
					stack1.add(id1);
					Collections.addAll(stack2, membersWithDegree(pal.getName(), degrees - 1));
					System.out.println("To br removed: " + stack1.toString());
					stack2.removeAll(stack1);
				}
			}
		}
		return stack2.toArray(new String[stack2.size()]);
	}

	/**
	 * Returns true if two members are connected through a chain of pals
	 * @param id1 the id of one member
	 * @param id2 the id of another member (could be the same)
	 * @return true if connected, false otherwise
	 */
	public boolean areConnected(String id1, String id2) {
		if(degreesOfSeparation(id1, id2) >= 0) {
			return true;
		}
		return false;
	}
}
