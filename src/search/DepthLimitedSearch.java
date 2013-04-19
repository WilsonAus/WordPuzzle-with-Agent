package search;

public class DepthLimitedSearch extends GeneralSearch {
	
	public DepthLimitedSearch(State startState, NodeInfo nodeInfo) {
		super(startState, nodeInfo);
		// TODO Auto-generated constructor stub
	}

	public Node select() {
		  return (Node) visited.get(0);
	  }
	  
	  public void insert(Node node) {
		  if(!nodeInfo.isTerminal(node)) {
			  unvisited.add(0, node);
		  }
	  }
}
