package wordChess;
import search.WordState;
import agent.Percept;


public class SnapShot implements Percept {

	
	private StringBuffer current;
	private int index;
	public int timesCycled;
	
	public SnapShot(StringBuffer word) {
		current = word;
		index = word.length() - 1;
		timesCycled = 0;
	}
	
	public StringBuffer getState() {
		return current;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void nextLetter() {
		if ( index == 0 ) {	
			index = 0;
		}
		else {
			index--;
		}
	}
	
	public void changeState(StringBuffer change) {
		current = change;
	}
	
	
	
	
}
