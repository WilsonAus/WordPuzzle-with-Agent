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
	WordNodeInfo game;
	public StringBuffer start;
	public StringBuffer finish;
	
	public WordSmith(WordNodeInfo info) {
		current = info.initial.length();
		start = info.initial;
		finish = info.goal;
		game = info;
	}
	
	public Node depthFirstSearch(StringBuffer start, StringBuffer goal){ 
		WordState startState = new WordState();
		startState.word = start;
		startState.info = game;
		DepthFirstSearch dfs = new DepthFirstSearch(startState, game);
		return dfs.search();
	}
	
	
	public Action getAction(Percept percept) {
		/* Current percept */
		SnapShot now = (SnapShot) percept;
		int n = now.getIndex();
		
		/*StringBuffer to hold current percepts word state*/
		StringBuffer word = now.getState();
		
		/*Buffer to hold next move once worked out*/
		Step next;
		
		char x = word.charAt( now.getIndex());
		if( n == 0 ) { return null; }
		if(now.timesCycled == 26) { now.nextLetter(); }
		if( word.charAt(now.getIndex()) == 'Z') { 
			next = new Step(now.getIndex(), 'A');
			now.timesCycled++;
		}
		else {
			word.setCharAt(now.getIndex(), x++);
			next = new Step(now.getIndex(), x);
			now.timesCycled++;
		}
		
		
		return next;	
		
	}
}
