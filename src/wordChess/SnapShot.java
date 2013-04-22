package wordChess;
import search.WordState;
import agent.Percept;


public class SnapShot implements Percept {

	
	private StringBuffer current;
	private int index;
	private int timesCycled;
	
	public SnapShot(StringBuffer word) {
		current = word;
		index = word.length - 1;
	}
	
	public StringBuffer getState() {
		return current;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void nextLetter() {
		if ( current == 0 ) {	
			current = 0;
		}
		else {
			current --;
		}
	}
	
	public void changeState(StringBuffer change) {
		current = change;
	}
	
	
	
	
}
