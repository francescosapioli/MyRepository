package it.polito.tdp.spellchecker.model;

import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	List<String> words;
	
	
	
	public void loadDictionary(){
		
		words = new LinkedList<String>();
		
	}
	
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		
		
		List<RichWord> result = new LinkedList<RichWord>();
		
		for(String s : inputTextList){
			RichWord w= new RichWord(s);
			
			//ricerca effettuata scorrendo gli elemtenti del dizionario dal primo in avanti:
			
			if(words.contains(s)){
				w.setCorrectWrong(true);
				System.out.println(this.words.indexOf(s));
			}
			else{
				w.setCorrectWrong(false);
			}
			
			result.add(w);
			//ricerca dicotomica     21427
			/*
			w.setCorrectWrong(false);
			
			int inizio;
			int centro;
			int fine;
			
			inizio = 0;
			fine = this.words.size()-1;
			
			while(inizio!=fine){
				
				
				centro = inizio + (fine-inizio)/2;
				
				
				System.out.println("inizio:"+inizio+"-centro:"+centro+"-fine:"+fine+"-valore:"+w.isCorrect());
				
				
				if(this.words.get(centro).compareTo(s)==0) //trovata corrispondenza
				{
					
					w.setCorrectWrong(true);
					break;
					
					
				}
				else{
					if(s.compareTo(this.words.get(centro))>0){// cerco a sinistra
						
					inizio = centro+1;
						
					}
					else{//cerco a destra
						
					fine = centro;
						
					}
				}
				
				System.out.println("inizio:"+inizio+"-centro:"+centro+"-fine:"+fine+"-valore:"+w.isCorrect());
				
			}
			
			//if(w.isCorrect()!=true)
			//	w.setCorrectWrong(false);
			
			result.add(w);
				
			
		}
		*/
		}
		return result;
	
	
	
	
	}
}
