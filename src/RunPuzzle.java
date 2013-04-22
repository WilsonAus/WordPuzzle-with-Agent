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
		
		WordNodeInfo info = new WordNodeInfo(initial, finish);
		
		WordSmith brain = new WordSmith(info);
		
		brain.depthFirstSearch(info.initial, info.goal);
		
		WordPuzzle environment = new WordPuzzle();
		SnapShot percept = new SnapShot(initial);
		
		
		
	}
}
