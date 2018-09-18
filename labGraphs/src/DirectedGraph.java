import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DirectedGraph {

	// All the nodes in the graph
	private ArrayList<Node> nodes;
	private int edgeCount;

	/*
	 * Creates a new graph with no nodes.
	 */
	public DirectedGraph() {
		nodes = new ArrayList<Node>();
		edgeCount = 0;
	}

	/*
	 * TODO #1: Returns the number of nodes in the graph.
	 */
	public int getNodeCount() {
		return nodes.size();
	}

	/*
	 * Adds a node with a specified name. Returns true iff node is successfully
	 * added.
	 */
	public boolean addNode(char data) {
		if (contains(data))
			return false; // node already exists
		else {
			nodes.add(new Node(data));
			return true;
		}
	}

	/*
	 * Returns true iff a new edge is created from the start node to the end node.
	 */
	public boolean addEdge(char start, char end) {
		if (start == end)
			return false;
		if (!this.contains(start) || !this.contains(end))
			return false;

		// Already neighbors? Done
		Node startNode = getNode(start);
		Node endNode = getNode(end);

		// Make them neighbors
		if (startNode.addNeighbor(endNode)) {
			edgeCount++;
			return true;
		} else {
			return false;
		}
	}

	/*
	 * TODO #2: Returns true iff start and end are nodes in the graph and there is
	 * an edge from start to end. Use hasNeighbor from the node class to help us.
	 */
	public boolean hasEdge(char start, char end) {
		Node startNode = getNode(start);
		if(startNode == null)
			return false;
		
		Node endNode = getNode(end);
		
		return startNode.hasNeighbor(endNode);
	}

	/*
	 * TODO #4: Performs a breadth-first search, which uses a QUEUE to help keep
	 * track. Returns an empty array if the start location does not exist.
	 */
	public char[] breadthFirstSearch(char start) {
		
		Node startNode = getNode(start);
		if(startNode == null){
			return new char[] {}; //Empty array
		}
		
		//Mark all nodes as unvisited
		for(Node n : nodes){
			n.visited = false;
		}
		
		// A place to store the path
		ArrayList<Node> path = new ArrayList<Node>();
		
		//Queue to put first node in, and then, as needed
		//put in "unvisited 
		Queue<Node> q = new LinkedList<Node>();
		q.add(startNode);
		startNode.visited = true;
		
		while(!q.isEmpty()){
			
			//Take the front item from the queue
			Node front = q.remove();
			
			//put in the path
			path.add(front);
			
			//add its unvisited neighbors to the queue
			for(Node neighbor : front.getNeighbors()){
				if(!neighbor.visited){ // !path.contains(neighbor) works too
					q.add(neighbor);
					neighbor.visited = true;
				}
			}
						
		}
		

		// Returns the path as a char[]
		char[] result = new char[path.size()];
		for (int i = 0; i < path.size(); i++) {
			result[i] = path.get(i).label;
		}
		return result;
	}

	/*
	 * TODO #5: Returns the length of the shortest path from start to end, or
	 * returns -1 if start or end does not exist or if there is no path from start
	 * to end. This essentially performs a breadth-first search until the desired
	 * node has been visited, or until it is determined that the desired node is not
	 * reachable.
	 */
	public int shortestPath(char start, char end, Stack<Character> path) {
		Node startNode = getNode(start);
		Node endNode = getNode(end);
		if(startNode == null || endNode == null){
			return -1; //Empty array
		}
		
		//Mark all nodes as unvisited
		for(Node n : nodes){
			n.visited = false;
		}
		
		//Queue to put first node in, and then, as needed
		//put in "unvisited 
		Queue<Node> q = new LinkedList<Node>();
		q.add(startNode);
		startNode.visited = true;
		
		while(!endNode.visited && !q.isEmpty()){
			
			//Take the front item from the queue
			Node front = q.remove();
			
			//put in the path
			//path.add(front);
			
			//add its unvisited neighbors to the queue
			for(Node neighbor : front.getNeighbors()){
				if(!neighbor.visited){ // !path.contains(neighbor) works too
					q.add(neighbor);
					neighbor.previousNode = front;
					neighbor.distance = 1 + front.distance; //TODO NOT DONE YET
					neighbor.visited = true;
				}
			}
						
		}
		return -1; //TODO FIx
	}

	/*
	 * TODO #6: Performs a depth-first search, which uses a STACK to help with
	 * backtracking. Returns an empty array if the start location does not exist.
	 */
	public char[] depthFirstSearch(char start) {
		// A place to store the path
		ArrayList<Node> path = new ArrayList<Node>();

		// Returns the path as a char[]
		char[] result = new char[path.size()];
		for (int i = 0; i < path.size(); i++) {
			result[i] = path.get(i).label;
		}
		return result;
	}

	/*
	 * Gets the number of edges.
	 */
	public int getEdgeCount() {
		return edgeCount;
	}

	/*
	 * Returns true iff the given node specified by label exists.
	 */
	private boolean contains(char label) {
		return nodes.contains(new Node(label));
	}

	/*
	 * Gets the node with the specified label, or null if the node doesn't exist.
	 */
	private Node getNode(char label) {
		Node result = null;
		int index = nodes.indexOf(new Node(label));

		if (index > -1)
			result = nodes.get(index);

		return result;
	}

	/*
	 * A String representation of this graph, listing each node and its neighbors
	 */
	public String toString() {
		String result = "";
		for (Node n : nodes) {
			result = result + n + "\n";
		}
		return result;
	}

	/*
	 * A private Node class. Each node has a label and a collection of neighbors
	 */
	private class Node {
		private char label;
		private ArrayList<Node> neighbors;
		private boolean visited; // needed for search and for shortest path
		private int distance; //Needed for shortest path
		private Node previousNode; //Needed for shortest path

		private Node(char label) {
			this.label = label;
			this.neighbors = new ArrayList<Node>();
			this.visited = false;
			this.distance = 0;
			this.previousNode = null;
		}

		@Override
		public String toString() {
			String result = label + " [";
			for (Node n : neighbors) {
				result += n.label + " ";
			}
			return result.trim() + "]";
		}

		/*
		 * If the node n is not already a neighbor, adds n as a neighbor. Returns true
		 * iff a new neighbor was added.
		 */
		private boolean addNeighbor(Node n) {
			if (!hasNeighbor(n)) {
				neighbors.add(n);
				return true;
			}
			return false;
		}

		/*
		 * Returns true iff this node has n as a neighbor
		 */
		private boolean hasNeighbor(Node n) {
			return neighbors.contains(n);
		}

		private ArrayList<Node> getNeighbors() {
			return neighbors;
		}

		// Two nodes are equal if they have the same label:
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof Node))
				return false;
			Node other = (Node) obj;
			if (label != other.label)
				return false;
			return true;
		}

	}

}
