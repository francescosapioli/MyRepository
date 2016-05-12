package it.polito.tdp.lab3.model;

import java.util.List;

public class Studente {
	
	
	private Integer matricola;
	private String nome;
	private String cognome;
	private String cds;
	private List<Corso> corsi;
	public Integer getMatricola() {
		return matricola;
	}
	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCds() {
		return cds;
	}
	public void setCds(String cds) {
		this.cds = cds;
	}
	public List<Corso> getCorsi() {
		return corsi;
	}
	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
	@Override
	public String toString() {
		return matricola + " " + nome + " " + cognome + " " + cds + " ";
	}
	public Studente(Integer matricola) {
		this.matricola = matricola;
	}
	public Studente(Integer matricola, String nome, String cognome) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}
	public Studente(Integer matricola, String nome, String cognome, String cds) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.cds = cds;
	}
	public Studente(Integer matricola, String nome, String cognome, String cds, List<Corso> corsi) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.cds = cds;
		this.corsi = corsi;
	}
	
	
	
	
	
	

}
