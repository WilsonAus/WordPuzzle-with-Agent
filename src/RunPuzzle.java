import java.util.Scanner;

import wordChess.WordPuzzle;
import wordPlayer.WordSmith;

import agent.Action;


public class RunPuzzle {
	public static void main(String[] args) {
		
		Scanner user_input = new Scanner(System.in);
		
		
		StringBuffer initial;
		System.out.print("Enter the initial word of the puzzle:");
		initial = new StringBuffer( user_input.next() );
		
		StringBuffer finish;
		System.out.print("Enter the finishing word of the puzzle:");
		finish = new StringBuffer( user_input.next() );
		
		WordPuzzle game = new WordPuzzle( initial, finish);
		
		WordSmith solve = new WordSmith(finish, initial.length() - 1);
		
		
		while (game.equals(game.getPercept().getState().word, game.fin) == false ) {
			int i = solve.getCurrent();
			StringBuffer state = game.getPercept().getState().word;
			if(state.charAt(i) == game.fin.charAt(i)) {
				solve.nextLetter();
			}
			else {
				Action next = solve.getAction(game.getPercept());
				
				game.update(next);
			}
		}
		if ( game.equals(game.getPercept().getState().word, game.fin) == false ) System.out.println(game.fin);
		
		System.out.println("Puzzle has been solved.");
	}
}
