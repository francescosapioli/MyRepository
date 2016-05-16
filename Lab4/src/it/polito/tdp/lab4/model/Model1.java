package it.polito.tdp.lab4.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab4.db.RichPermutations;

public class Model1 {
	
	List<String> permutations =  null;

	RichPermutations rp;
	
	public List<RichWord> richPermutations(String word){
		
		rp = new RichPermutations();
		//System.out.println(this.rp.verifieWord(this.findPermuatations(word)).toString());
		
		return this.rp.verifieWord(this.findPermuatations(word));
	}
	
	
	public List<String> findPermuatations(String word){
		
		this.permutations = new LinkedList<String>();
		
		this.recursivePermutaitons(word, 0);
		
		return this.permutations;
	}
	
	
	private void recursivePermutaitons(String word, int passo){
		
		if(passo == word.length()){
			this.permutations.add(word);
			return;
		}
		
		
		for(int i =passo; i<word.length(); i++){
			
			char[] chars = word.toCharArray();
			
			char temp = chars[i];
			chars[i] = chars[passo];
			chars[passo] = temp;
			
			
			this.recursivePermutaitons(String.valueOf(chars), passo+1);
			
		}
		
		
		
		
		
		
		
		
		
		
		/*
		if(passo == word.length()){
			this.permutations.add(word);
			return;
		}
		
		for(int i = passo; i<word.length(); i++){
			
			char[] chars = word.toCharArray();
			
			char temp  = chars[passo];
			chars[passo] = chars[i];
			chars[i] = temp;
			
			
			this.recursivePermutaitons(String.valueOf(chars), passo+1);
			
		}
		
	*/	
		
	}
	

}
