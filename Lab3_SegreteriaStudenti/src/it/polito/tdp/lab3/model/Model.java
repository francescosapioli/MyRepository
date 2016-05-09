package it.polito.tdp.lab3.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
	
	private List<Studente> studenti = new LinkedList<Studente>();
	private List<Corso> corsi = new LinkedList<Corso>();
	
	
	public List<Studente> getStudenti() {
		return studenti;
	}
	
	
	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}
	
	
	public List<Corso> getCorsi() {
		return corsi;
	}
	
	
	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
	
	
	
	
	
	
	

}
