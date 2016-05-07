package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	private LinkedList<String> parole= new LinkedList<String>();
	
	public void addParola(String p){ // aggiunge nuova parola
		parole.add(p);
	}
	
	public List<String> getElenco(){ // restituisce elenco parole ordinate
		
		Collections.sort(parole);
		return parole;
		
	}
	
	
	public void reset() {// azzera elenco parole
	
	parole.clear();
	
	}

}
