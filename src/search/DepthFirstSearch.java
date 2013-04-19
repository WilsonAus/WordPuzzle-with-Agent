package search;

public class DepthFirstSearch extends GeneralSearch {
	 
	
	  public DepthFirstSearch(State startState, NodeInfo nodeInfo) {
		  super(startState, nodeInfo);
	  }
	  
	  public Node select() {
		  return (Node) visited.get(0);
	  }
	  
	  public void insert(Node node) {
		  unvisited.add(0, node);
	  }
}
