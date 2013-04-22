package wordChess;

import java.io.File;
import java.io.IOException;

import search.WordState;

import com.swabunga.spell.engine.SpellDictionary;
import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.event.SpellChecker;
import com.swabunga.spell.event.StringWordTokenizer;

import agent.Action;
import agent.Environment;



public class WordPuzzle implements Environment{
	
	public StringBuffer str;
	public StringBuffer fin;
	
	public SnapShot current;
	
	
	
	
	public Object clone()  {
	return this.clone();
	}
	
	public String toString(StringBuffer buff) {
		
		return buff.toString();
	}
	
	public boolean equals(StringBuffer a, StringBuffer b) {
		String str1 = a.toString();
		String str2 = b.toString();
		if ( str1.compareTo(str2) == 0 ) return true;
		
		return false;
		
	}
	
	public SnapShot getPercept() {
		return current;
	}
	
	
	public void update(Action step) throws RuntimeException {
	
		Step move = (Step) step;
		
		String word = current.getState().toString();
		word = word.toLowerCase();

		
		if (move.getPos() > fin.length()) {
			throw new RuntimeException("Invalid Position");
		}
		
		int result = 0;
				
		try {
			SpellDictionary dictionary;
			dictionary = new SpellDictionaryHashMap(new File("bin/english.0"));
			SpellChecker spellChecker = new SpellChecker(dictionary);
			result = spellChecker.checkSpelling(new StringWordTokenizer(word));
			if (result == SpellChecker.SPELLCHECK_OK) System.out.println(current.getState());
		}   catch (IOException e) {
			e.printStackTrace();
		}
		
			current.getState().setCharAt(move.getPos(), move.getTo());
		

	}
			
}


