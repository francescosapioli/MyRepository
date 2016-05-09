package it.polito.tdp.spellchecker.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	final static boolean dicotomic = false;
	
	//protected List<String> dictionaryWords;
	protected HashSet<String> dictionaryWords;
	
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		
		List<RichWord> result = new LinkedList<RichWord>();
		
		
		if(dicotomic==false){
			// inizio ricerca classica 
		for(String s : inputTextList){
			
			RichWord w = new RichWord(s);
			
			if(this.dictionaryWords.contains(s))
				w.setCorrect(true);
			else
				w.setCorrect(false);
			
			result.add(w);
				
		}
		//fine ricerca classica
		}
		
		else{
			/*
			//inizio ricerca dicotomica
			
			//System.out.println(this.dictionaryWords.size());
			for( String s : inputTextList){
				int inizio = 0;
				int fine = this.dictionaryWords.size();
				
				RichWord w = new RichWord(s);
				w.setCorrect(false);
				
				while(inizio != fine){
					
					int medio = inizio + (fine - inizio)/2;
					
					//System.out.println("inizio:"+inizio+"-medio:"+medio+"-fine:"+fine);
						
						if(s.compareTo(this.dictionaryWords.get(medio))==0){
							w.setCorrect(true);
							break;
						}
						else{
							if(s.compareTo(this.dictionaryWords.get(medio))>0)
								inizio = medio+1;
						else
								fine = medio;
						}
					
				}
			
			result.add(w);
			}
			*/
			//fine ricerca dicotomica
		}
		
		
		return result;
	}
	
	
	
	
	public void loadDictionary(){
		
		this.dictionaryWords = new HashSet<String> ();
		
	}

}
