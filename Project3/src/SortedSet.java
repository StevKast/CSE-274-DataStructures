
/**
 * Steven Kast, kastsm
 * Project 3
 *
 * A linked-node implementation of the Set ADT in which elements of the set
 * are always sorted (in this case, lexicographically, which is a fancy
 * way of saying "alphabetically").  Note that the String class has a compareTo
 * method which you should be using to assist you in keeping the set sorted.
 * 
 */
public class SortedSet implements SetInterface<String> {

	private int size;
	private Node head;

	public SortedSet(){
		size = 0;
		head = null;
	}

	/** Gets the current number of entries in this set.
	 @return  The integer number of entries currently in the set. */
	@Override
	public int getCurrentSize() {
		return size;
	}

	/** Sees whether this set is empty.
	 @return  True if the set is empty, or false if not. */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/** Adds a new entry to this set, avoiding duplicates. Keeps set sorted lexicographically
	 @param newEntry  The object to be added as a new entry.
	 @return  True if the addition is successful, or false if the item already is in the set. */
	@Override
	public boolean add(String newEntry) {
		Node current = head;

		if(head == null){
			head = new Node(newEntry);
			size++;
			return true;
		}

		while(current != null && !contains(newEntry)){
			if (newEntry.compareTo(current.data) >= 0 &&
					(current.next == null || newEntry.compareTo(current.next.data) <= 0)){
				Node newNode = new Node(newEntry);
				newNode.next = current.next;
				current.next = newNode;
				size++;
				return true;
			}
			current = current.next;
		}

		return false;
	}

	/** Removes a specific entry from this set, if possible.
	 @param anEntry  The entry to be removed.
	 @return  True if the removal was successful, or false if not. */
	@Override
	public boolean remove(String anEntry) {
		Node current = head;
		if(current.data.equals(anEntry)){
			head = current.next;
			return true;
		}

		while(current.next != null){
			if(current.next.data.equals(anEntry)){
				current.next = current.next.next;
				return true;
			}
			current = current.next;
		}
		return false;
	}

	/** Removes one unspecified entry from this set, if possible.
	 @return  Either the removed entry, if the removal
	 was successful, or null. */
	@Override
	public String remove() {
		Node origHead = head;
		head = head.next;
		return origHead.data;
	}

	/** Removes all entries from this set. */
	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	/** Tests whether this set contains a given entry.
	 @param anEntry The entry to locate.
	 @return True if the set contains anEntry, or false if not. */
	@Override
	public boolean contains(String anEntry) {
		Node current = head;
		while (current != null){
			if(current.data.equals(anEntry)){
				return true;
			}
			current = current.next;
		}
		return false;
	}

	/*
	 * returns a string representation of the items in the bag,
	 * specifically a space separated list of the strings, enclosed
	 * in square brackets [].  For example, if the set contained
	 * cat, dog, then this should return "[cat dog]".  If the
	 * set were empty, then this should return "[]".
	 */
	@Override
	public String toString() {
		Node current = head;
		String ans = "[";
		while(current != null){
			ans += current.data + " ";
			current = current.next;
		}
		//return ans;
		return ans.trim() + "]";
	}
	
	@Override
	public String[] toArray() {
		String[] ret = new String[size];
		Node current = head;
		for(int i = 0; i < size; i++){
			ret[i] = current.data;
			current = current.next;
		}
		return ret;

	}

	//Private inner class for nodes.
	private class Node{
		private String data;
		private Node next;

		private Node(String data) {
			this.data = data;
		}

	}

}
