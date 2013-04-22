package wordChess;
import search.WordState;
import agent.Percept;


public class SnapShot implements Percept {

	
	private StringBuffer current;
	private int index;
	
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
