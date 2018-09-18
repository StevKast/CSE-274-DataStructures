//Steven Kast

public class UndirectedGraph extends DirectedGraph {
	
	@Override
	public boolean addEdge(char start, char end){
		return super.addEdge(start, end) && super.addEdge(end, start);
	}
	
	@Override
	public int getEdgeCount(){
		return super.getEdgeCount() / 2;
	}

}
