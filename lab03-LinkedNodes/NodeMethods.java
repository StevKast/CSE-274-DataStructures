public class NodeMethods {

	public static void main(String[] args) {
		Node result = build123();
		
		System.out.println(nodesToString(result));
		
		result = addToHead(result, 7);
		System.out.println(nodesToString(result));
		
		result = addToTail(result, 99);
		System.out.println(nodesToString(result));

		Node oneToHund = build1To100();
		System.out.println(countNodes(oneToHund) + " " + nodesToString(oneToHund));

		System.out.println(countNodes(oneToHund) + " " + lastValue(oneToHund));
		System.out.println("100 true? " + contains(oneToHund, 100));
		System.out.println("1 true? " + contains(oneToHund, 1));

	}

	/*
	 *  **** Problem 1: Returns a set of linked nodes 1 -> 2 -> 3 by returning
	 * the head of that node.
	 */
	public static Node build123() {
		Node n = new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		
		return n;
	}

	/*
	 *  **** Problem 2: Returns the contents of a list of linked nodes, beginning
	 * with the specified node
	 */
	public static String nodesToString(Node head) {
		String result = "[";
		while(head != null){
			result = result + head.data + " ";
			head = head.next;
		}
		return result.trim() + "]";
	}

	/*
	 *  **** Problem 3: Adds the specified value to the start of a list of linked
	 * nodes. NOTE: The head of the list will change, which is why it is
	 * necessary to return a new node that marks the head of the linked nodes.
	 */
	public static Node addToHead(Node head, int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		return newNode;
	}

	/*
	 *  **** Problem 4: Removes the first item from the list. If the list
	 * contains only one node, returns null. If the head is null to begin with,
	 * also returns null
	 */
	public static Node removeHead(Node head) {
		return head.next;
	}

	/*
	 *  **** Problem 4: Returns a set of linked nodes 1 -> 2 -> 3 .... all the
	 * way to n returning the head of that node.
	 */
	public static Node build1To100() {
		Node head = new Node(100);
		for(int i = 99; i > 0; i--){
			head = addToHead(head, i);
		}
		return head;
	}

	/*
	 * **** Problem 6: Returns a count of the number of nodes in a list
	 */
	public static int countNodes(Node head) {
		int count = 1;
		while(head.next != null){
			head = head.next;
			count++;
		}
		return count;
	}
	
	/*
	 * **** Problem 7: Returns true if the list contains the value, and false
	 * otherwise.
	 */
	public static boolean contains(Node head, int value) {
		while(head != null){
			if(head.data == value){
				return true;
			}
			head = head.next;
		}
		return false;
	}
	
	/*
	 * **** Problem 8: Returns the last value in a list
	 */
	public static int lastValue(Node head) {
		while(head.next != null){
			head = head.next;
		}
		return head.data;
	}
	
	/*
	 *  **** Problem 9: Adds the specified value to the end of a list of linked
	 * nodes. NOTE: The head of the list usually won't change, but could change if
	 * there is only one node in the list.
	 */
	public static Node addToTail(Node head, int value) {
		Node originalHead = head;
		while(head.next != null){
			head = head.next;
		}
		head.next = new Node(value);
		return originalHead;
	}

	/*
	 *  **** Problem 10: Removes the last item from the list. If the list
	 * contains only one node, returns null. 
	 */
	public static Node removeTail(Node head) {
		Node originalHead = head;
		while(head.next.next != null){
			head = head.next;
		}
		head.next = null;
		return originalHead;
	}
	
	
	/*
	 * **** Problem 11: Returns the head a linked list of n random nodes.
	 * Assume length >= 0
	 */
	public static Node buildRandomNodes(int length) {
		Node n = new Node((int)(Math.random() * 10));
		for (int i = 1; i < length; i++){
			n = addToHead(n, (int)(Math.random() * 10));
		}
		return n;
	}
	
	
}
