import java.util.Arrays;
import java.util.Stack;

public class Tester {

	public static void main(String[] args) {
		
		// To Do #3: 
		// You have a DirectedGraph class already.  
		// Create an UndirectedGraph class.  
		DirectedGraph g = new DirectedGraph();
		g.addNode('A');
		g.addNode('B');
		g.addNode('C');
		g.addNode('D');
		g.addNode('E');
		g.addNode('F');
		g.addNode('G');
		g.addNode('H');	
		g.addNode('D');
		System.out.println("Node Count == 8? " + g.getNodeCount());
		System.out.println("Edge Count == 0? " + g.getEdgeCount());
		
		System.out.println("These should both be false...");
		System.out.println("Edge from A to G? " + g.hasEdge('A', 'G'));
		System.out.println("Edge from G to A? " + g.hasEdge('G', 'A'));
		System.out.println("Adding edge from A to G...");
		g.addEdge('A', 'G');
		//////
		
		g.addEdge('W', 'A');
		g.addEdge('A', 'W');
		g.addEdge('W', 'X');
		g.addEdge('W', 'W');
		
		System.out.println("W to A? Should be false: " + g.hasEdge('W', 'A'));
		
		System.out.println("Now what?");
		System.out.println("Edge from A to G? " + g.hasEdge('A', 'G'));
		System.out.println("Edge from G to A? " + g.hasEdge('G', 'A'));
		g.addEdge('A', 'C');
		g.addEdge('A', 'B');
		g.addEdge('B', 'F');
		g.addEdge('C', 'E');
		g.addEdge('C', 'A');
		g.addEdge('D', 'G');
		g.addEdge('D', 'B');
		g.addEdge('F', 'E');
		g.addEdge('F', 'G');
		g.addEdge('G', 'D');
		g.addEdge('H', 'B');
		g.addEdge('H', 'E');
		g.addEdge('H', 'E');
		
		System.out.println("Node Count == 8? " + g.getNodeCount());
		System.out.println("Edge Count == 13? " + g.getEdgeCount());
		System.out.println(g);
		
		////////
		char[] path = g.breadthFirstSearch('A');
		System.out.println(Arrays.toString(path));
		
		
	}

}
