package search;

public class BreadthFirstSearch extends GeneralSearch {
		  
		  public BreadthFirstSearch(State startState, NodeInfo nodeInfo) {
			  super(startState, nodeInfo);
		  }
		  
		  public Node select() {
			  return (Node) visited.get(0);
		  }
		  
		  public void insert(Node node) {
			  unvisited.add(node);
		  }
}
