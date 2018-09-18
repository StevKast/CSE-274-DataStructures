
public class LinkedBag implements BagInterface<String> {

	private Node head;
	private int size;
	
	/*
	 * Constructs an empty bag
	 */
	public LinkedBag() {
		head = null;
		size = 0;
	}
		
	
	@Override
	public int getCurrentSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/*
	 * Adds a new node to the start, because it's more efficient.
	 * Wraps a new node around the data.  Then we make that new node
	 * the head of the list, first pointing it to the old head.
	 */
	@Override
	public boolean add(String newEntry) {
		
		Node newNode = new Node(newEntry);

		newNode.next = head;
		head = newNode;
		size++;
		
		// As long as there is memory remaining in the computer, this method should always succeed.
		return true;	
	}

	/*
	 * Since it's a bag, the programmer is free to choose which element to remove and return.
	 * So, since we want to be efficient programmers, we will remove the first node by advancing
	 * the head.
	 * Note the special case: if the bag is empty, return null.
	 */
	@Override
	public String remove() {
		if(size == 0){
			return null;
		}
		String removed = head.data;
		head = head.next;
		size--;
		return removed;
	}

	/*
	 * THE EASIEST NODE TO REMOVE IS THE FIRST NODE.  So, here is the algorithm:
	 * 1. Find the first occurrence of the string you want to remove.
	 * 2. COPY THE DATA from the first node to the node you found in step 1.
	 * 3. Remove the FIRST node.
	 * "But won't this mess up the order? Yes. But order doesn't matter. It's a bag."
	 * "Isn't it cheating to just copy the data? No. It's not cheating. It's clever."
	 */
	@Override
	public boolean remove(String anEntry) {
		Node current = head;
		while(current != null){
			if(current.data.equals(anEntry)){
				current.data = head.data;
				remove();
				return true;
			}
			current = current.next;
		}
		return false;
	}

	/*
	 * Just set the head to null (and the size to 0).
	 * "But won't this leave a bunch of nodes hanging around in memory?  No.  As soon
	 *  as we stop pointing to the first node, it will get marked as garbage so that memory
	 *  can be cleaned up."
	 */
	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	// Returns a count of the number of items equal to anEntry
	@Override
	public int getFrequencyOf(String anEntry) {
		Node current = head;
		int count = 0;
		while(current != null){
			if(current.data.equals(anEntry)){
				count++;
			}
			current = current.next;
		}
		return count;
	}

	// Returns whether or not anEntry appears in this bag
	@Override
	public boolean contains(String anEntry) {
		Node current = head;
		while(current != null){
			if(current.data.equals(anEntry)){
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// Returns an array consisting of the elements in the bag
	// If there are no items, return an array of size 0. This method
	// should never return null.
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
	
	public String toString() {
		String result = "";
		Node current = head;
		while (current != null) {
			result = result + current.data + " ";
			current = current.next;
		}
		
		return result;
		
	}
	
	// A private inner class.  Notice that
	// the outer class can freely access its inner class, even 
	// though it's private.
	private class Node {
		private String data;
		private Node next;
		
		private Node(String data) {
			this.data = data;
		}
	}
	
	

}
