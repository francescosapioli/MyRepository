package it.polito.tdp.alien;

import java.util.LinkedList;

public class WordEnhanced {
	
	
	private String alienWord;
	private LinkedList<String> translations=new LinkedList<String>();
	
    public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translations.add(translation);
	}

	public String compare(String alienWord){
		
		
		if(alienWord.compareToIgnoreCase(this.alienWord)==0)
		  return this.translations.toString();
		
		return null;
		
	}
	
	public void aggiungiTraduzione(String trad){
		
		boolean flag= false;
		if(translations!=null){
		for(String temp : translations){
			if(temp.compareToIgnoreCase(trad)==0){
				flag=true;
				break;
			}
		}
		}
		if(flag==false)
			this.translations.add(trad);
	}
	
	

	
	
	
	
	
	

}
