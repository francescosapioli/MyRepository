package it.polito.tdp.lab3.model;

import java.util.List;

public class Corso {
	
	private String nome;
	private List<Studente> studenti;
	
	
	
	public List<Studente> getStudenti() {
		return studenti;
	}
	
	public boolean studenteIscritto(Studente s){
		if(this.studenti.contains(s))
			return true;
		return false;
	}
	
	
	public void iscriviStudente(Studente s){
		this.studenti.add(s);
		
	}
	
	

}
