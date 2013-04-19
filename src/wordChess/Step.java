package wordChess;
import agent.Action;


public class Step implements Action {

		private int position;
		private char to;
		
		public Step (int p, char c) {position = p; to = c;}
		
		public int getPos() { return position; }
		
		public char getTo() { return to; }
		
		public double getCost() {
			return 1;
		}
		
		
}
