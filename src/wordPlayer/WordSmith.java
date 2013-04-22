package wordPlayer;
import search.*;
import wordChess.SnapShot;
import wordChess.Step;
import agent.Action;
import agent.Actions;
import agent.Agent;
import agent.Percept;


public class WordSmith implements Agent {

	private int current;
	WordNodeInfo info;
	
	public WordSmith(StringBuffer goal, int length) {
		current = length;
		info = new WordNodeInfo(goal);
	}
	
	
	public Node depthFirstSearch(StringBuffer start, StringBuffer goal){ 
		WordState startState = new WordState();
		startState.word = start;
		WordNodeInfo nodeInfo = new WordNodeInfo(goal);
		DepthFirstSearch dfs = new DepthFirstSearch(startState, nodeInfo);
		return dfs.search();
	}
	
	
	public Action getAction(Percept percept) {
		/* Current percept */
		SnapShot now = (SnapShot) percept;
		int n = now.getIndex();
		
		/*StringBuffer to hold current percepts word state*/
		StringBuffer word = now.getState().word;
		
		/*Buffer to hold next move once worked out*/
		Step next;
		
		if( n == 0 ) return null;
		
		char x = word.charAt(current);
		
		if( word.charAt(current) == 'Z') { 
			next = new Step(current, 'A');
		}
		else {
			word.setCharAt(current, x++);
			next = new Step(current, x);
		}
		
		
		return next;	
		
	}
}
