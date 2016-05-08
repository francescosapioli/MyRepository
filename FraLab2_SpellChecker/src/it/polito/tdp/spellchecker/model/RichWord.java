package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String word;
	private boolean correct;
	
	
	
	public RichWord(String word) {
		this.word = word;
	}
	
	
	
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}



	//metodo usato solo nel modello
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.word+"-"+this.correct;
	}



	//metodo usato solo nel modello
	public String getWord() {
		return word;
	}



	//metodo usato solo nel modello
	public boolean isCorrect() {
		return correct;
	}
	
	
	
	

}
