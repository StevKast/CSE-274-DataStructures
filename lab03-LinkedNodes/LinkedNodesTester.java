
public class LinkedNodesTester {

	public static void main(String[] args) {
		
		System.out.println("========================================");
		System.out.println("Create a list containing 1 to 100:");
		Node n = NodeMethods.build1To100();
		status(n);
		
		System.out.println("Create a list containing 10 random nodes:");
		n = NodeMethods.buildRandomNodes(10);
		status(n);
		
		System.out.println("Create a list containing 1 2 3:");
		n = NodeMethods.build123();
		status(n);
		
		System.out.println("Add 5 to the head:");
		n = NodeMethods.addToHead(n, 5);
		status(n);
		
		System.out.println("Add 9 and 1 to the head:");
		n = NodeMethods.addToHead(n, 1);
		n = NodeMethods.addToHead(n, 9);
		status(n);
		
		System.out.println("Contains the value 9? " + NodeMethods.contains(n, 9));
		System.out.println("Contains the value 3? " + NodeMethods.contains(n, 3));
		System.out.println("Contains the value 0? " + NodeMethods.contains(n, 0));
		System.out.println("========================================");
		
		System.out.println("Add 8 to the tail:");
		n = NodeMethods.addToTail(n, 8);
		status(n);
		
		System.out.println("Add 0 to the tail:");
		n = NodeMethods.addToTail(n, 0);
		status(n);		

		System.out.println("Contains the value 9? " + NodeMethods.contains(n, 9));
		System.out.println("Contains the value 3? " + NodeMethods.contains(n, 3));
		System.out.println("Contains the value 0? " + NodeMethods.contains(n, 0));
		System.out.println("========================================");
		
		System.out.println("Remove the first node:");
		n = NodeMethods.removeHead(n);
		status(n);
		
		System.out.println("Remove the last node:");
		n = NodeMethods.removeTail(n);
		status(n);
		
	}
	
	public static void status(Node n) {
		System.out.println("Content of the list: " + NodeMethods.nodesToString(n));
		System.out.println("Number of items in the list: " + NodeMethods.countNodes(n));
		System.out.println("Last node value: " + NodeMethods.lastValue(n));
		System.out.println("========================================");
	}
	
	

}
