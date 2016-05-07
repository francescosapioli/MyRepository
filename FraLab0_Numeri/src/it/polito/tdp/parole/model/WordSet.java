package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.UUID;

public class WordSet {
	
	private ArrayList<String> lista = new ArrayList<String>();
	
	// genera parole casuali e le inserisce in una lista
	public void generaParole(int numParole) {
		
		for(int i=0;i<=numParole+1;i++){
			lista.add(UUID.randomUUID().toString());
		}
		
		
	}
	// elimina l’elemento in posizione i e restituisce il tempo di esecuzione
	public long cancella(int i) {
		
		long t0 = System.nanoTime();
		
		lista.remove(i);
		
		long tempo = System.nanoTime()-t0;
		
		return tempo;
	}

}
