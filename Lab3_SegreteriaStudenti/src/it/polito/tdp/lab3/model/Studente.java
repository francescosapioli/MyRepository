package it.polito.tdp.lab3.model;

import java.util.List;

import it.polito.tdp.db.StudenteDAO;

public class Studente {
	
	private Integer matricola;
	private String nome;
	private String cognome;
	private String cds;
	
	private List<Corso> corsi;
	
	private StudenteDAO s = new StudenteDAO();
	
	
	@Override
	public boolean equals(Object obj) {
		Studente s =(Studente) obj; 
		
		if(this.matricola==s.matricola)
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
		corsi = s.getCorsi(this.matricola);
		return corsi;
	}


	public Integer getMatricola() {
		return matricola;
	}


	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
	
	public Studente trovaDaMatricola(Integer matricola){
		return s.setStudente(matricola);
	}
	
	
	
	
	
	

}
