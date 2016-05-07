package it.polito.tdp.alien;

public class Word {
	
	private String alienWord;
	private String translation;
	
	
	
	public Word(String alienWord, String translation) {
		this.alienWord=alienWord;
		this.translation=translation;
		
	}

	public String compare(String alienWord){
		
		
		if(alienWord.compareToIgnoreCase(this.alienWord)==0)
		  return this.translation;
		
		return null;
		
	}
	
	public void aggiornaTraduzione(String traslation){
		this.translation = traslation;
	}
	
	
	

}
