package it.polito.tdp.alien;

import java.util.LinkedList;

public class AlienDictionary {
	
	//private LinkedList<Word> parole=new LinkedList<Word>();
	private LinkedList<WordEnhanced> parole=new LinkedList<WordEnhanced>();
	
	public void addWord(String alienWord, String translation){
		
		boolean flag=true;
		
		for (WordEnhanced temp : parole){
			if(temp.compare(alienWord)!=null){
				temp.aggiungiTraduzione(translation);
				flag=false;
				break;
			}
			
		}
		if(flag==true)
			parole.add(new WordEnhanced(alienWord, translation));
		
		
	}
	
	
	public String translateWord(String alienWord){
		
		
	
		for (WordEnhanced temp : parole){
			if(temp.compare(alienWord)!=null)
				return temp.compare(alienWord);
			
	}
	return null;
 }	

}
