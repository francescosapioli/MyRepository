package it.polito.tdp.lab3.model;

import java.util.List;

public class Studente {
	
	private String matricola;
	private String nome;
	private String cognome;
	
	private List<Corso> corsi;
	
	
	@Override
	public boolean equals(Object obj) {
		Studente s =(Studente) obj; 
		
		if(this.matricola.compareToIgnoreCase(s.matricola)==0)
			return true;
		
		return false;
	}


	public String getNome() {
		return nome;
	}


	public String getCognome() {
		return cognome;
	}


	public List<Corso> getCorsi() {
		return corsi;
	}
	
	
	
	
	
	
	
	

}
