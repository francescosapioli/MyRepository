package it.polito.tdp.lab4.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
	
	private String currentWord = "";
	private List<String> result = new LinkedList<String>();
	 
	
	
	public List<String> getResult() {
		return result;
	}


	public void executePermutation(String word, Integer step){
		
		// CONDIZIONE DI TERMINAZIONE
		
		System.out.println("step:"+step+"----word.length:"+word.length()+"\n");
		
		if(step == word.length()){
			result.add(currentWord);
			return;
		}
		
		for(int i=0; i<word.length();i++){
		
		//FAI
		
		this.currentWord += word.charAt(i);
		
		System.out.println("currentWord:"+this.currentWord+"\n");
		
		
		//RICORSIONE
		
	
		System.out.println("step:"+step+"\n");
		this.executePermutation(word, step);
		
		//DISFA
		
		currentWord = this.currentWord.substring(0, currentWord.length()-1);
		
		System.out.println("currentWord:"+this.currentWord+"\n");
	}
		step++;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
