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
			
			/* ricerca effettuata scorrendo gli elemtenti del dizionario dal primo in avanti:
			if(words.contains(s))
				w.setCorrectWrong(true);
			else
				w.setCorrectWrong(false);
			*/
			
			//ricerca dicotomica
			
			w.setCorrectWrong(false);
			
			int inizio;
			int centro;
			int fine;
			
			inizio = 0;
			fine = this.words.size()-1;
			
			while(w.isCorrect()==false && inizio<=fine){
				
				centro = (inizio+fine)/2;
				
				if(this.words.get(centro).compareTo(s)==0) //trovata corrispondenza
				{
					
					w.setCorrectWrong(true);
					
				}
				else{
					if(this.words.get(centro).compareTo(s)>0){// cerco a desta
						
						inizio = centro+1;
						
					}
					else{//cerco a sinistra
						
						fine = centro-1;
						
					}
				}
				
			}
			
			
			
			result.add(w);
				
			
		}
		
		return result;
	}
	
	
	

}
