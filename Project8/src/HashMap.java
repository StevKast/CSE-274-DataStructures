/**
 * 
 * @author Steven Kast, kastsm
 *
 */

public class HashMap {

	private int arraySize = 16777216; //2^24 seems like a good start.
	private Node array[] = new Node[arraySize];

	public HashMap(){

	}

	public void put(Word word, int increase){

		int hash = Math.abs(word.hashCode() % arraySize);

		Node entry = new Node(word);

		//Case 1: No collision
		if(array[hash] == null){
			array[hash] = entry;
		}else{

			//Case 2: Collision detected, fixed with linked nodes

			Node current = array[hash];

			while (current.nextNode != null){
				if(current.data.hashCode() == hash){
					break;
				}
				current = current.nextNode;
			}

			//Check if new word is already in hashmap
			if(current.data.hashCode() == hash){
				current.data.increaseFrequency(increase);
				return;
			}

			//Not in hashmap so add it at the end of the list.
			current.nextNode = entry;
		}
	}

	public Word get(Word word){

		int hash = Math.abs(word.hashCode() % arraySize);

		Node n = array[hash];

		while(n != null) {
			if (n.data.equals(word)) {
				return n.data;
			}

			n = n.nextNode;
		}
		//Not found
		return null;

	}




	private class Node implements Comparable<Node>{
		private Node nextNode;
		private Word data;

		public Node(Word data){
			this.data = data;
			nextNode = null;
		}

		public Word getData(){
			return data;
		}

		@Override
		public int compareTo(Node o) {
			return data.compareTo(o.data);
		}
	}
}
