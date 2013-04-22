package wordPlayer;

import search.Node;
import search.NodeInfo;
import search.WordState;

public class WordNodeInfo implements NodeInfo {
	

	public StringBuffer initial;
	public StringBuffer goal;
	
	public WordNodeInfo(StringBuffer start, StringBuffer finish) {
		initial = start;
		goal = finish;
	}
		
	  /**
	   * @return true if this node is a goal node.
	   */
	public boolean isGoal (Node node) {
		 WordState current = (WordState) node.getState();
		 if(current.word.equals(goal)) return true;
		 return false;
	  }


	  /**
	   * @return true in cases where the search should terminate
	   */
	  public boolean isTerminal (Node node) {
		  return false;
	  }


	  /**
	   * @return the utility or estimated utility (evaluation function) of the node
	   */ 
	  public double utility (Node node) {
		  return  2;
	  }
	  
	  /**
	   * Set the depth/cost limit for depth limited and iterative deepending searches.
	   * @param limit the depth limit
	   */
	  public void setDepthLimit (double limit) {

	  }

	  /**
	   * Get the depth/cost limit for depth limited and iterative deepening searches.
	   * @return the depth limit
	   */
	  public double getDepthLimit () {
		  return 2;
	  }
}
