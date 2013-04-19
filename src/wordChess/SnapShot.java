package wordChess;
import search.WordState;
import agent.Percept;


public class SnapShot implements Percept {

	
	private StringBuffer current;
	
	public StringBuffer getState() {
		return current;
	}
	
	public void changeState(StringBuffer change) {
		current = change;
	}
	
	
	
}
