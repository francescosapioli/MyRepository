package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	
	private String word;
	private boolean Correct;
	
	
	


	public String getWord() {
		return word;
	}





	public boolean isCorrect() {
		return Correct;
	}





	public RichWord(String word) {
	
		this.word = word;
	}





	public void setCorrectWrong(boolean correctWrong) {
		Correct = correctWrong;
	}




/*
	@Override
	public String toString() {
		return "RichWord [word=" + word + ", Correct=" + Correct + "]";
	}
	
	*/
	
	

}
