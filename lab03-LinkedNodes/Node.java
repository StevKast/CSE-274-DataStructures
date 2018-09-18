/*
 * A classic simple Node with data and a link 
 * to the next node
 * Could make instance vars private and have getters
 * and setters but for right now we don't care
 */
public class Node {
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
		this.next = null;
	}
}
