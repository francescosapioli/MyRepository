package it.polito.tdp.spellchecker.model;

import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	List<String> words;
	
	
	
	public void loadDictionary(){
		
		words = new LinkedList();
		
	}
	
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		
		List<RichWord> result = new LinkedList();
		
		for(String s : inputTextList){
			RichWord w= new RichWord(s);
			if(words.contains(s))
				w.setCorrectWrong(true);
			else
				w.setCorrectWrong(false);
			
			result.add(w);
				
			
		}
		
		return result;
	}
	
	
	

}