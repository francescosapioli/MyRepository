package it.polito.tdp.lab3.model;

import java.util.List;

public class Corso {
	
	private String nome;
	private Integer pd;
	private Integer crediti;
	private String codins;
	private List<Studente> studenti;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPd() {
		return pd;
	}
	public void setPd(Integer pd) {
		this.pd = pd;
	}
	public Integer getCrediti() {
		return crediti;
	}
	public void setCrediti(Integer crediti) {
		this.crediti = crediti;
	}
	public String getCodins() {
		return codins;
	}
	public void setCodins(String codins) {
		this.codins = codins;
	}
	public List<Studente> getStudenti() {
		return studenti;
	}
	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}
	@Override
	public String toString() {
		return  this.nome ;
	}
	public Corso(String nome, Integer pd, Integer crediti, String codins, List<Studente> studenti) {
		this.nome = nome;
		this.pd = pd;
		this.crediti = crediti;
		this.codins = codins;
		this.studenti = studenti;
	}
	public Corso(String nome) {
		this.nome = nome;
	}
	public Corso(String nome, Integer pd, Integer crediti, String codins) {
		this.nome = nome;
		this.pd = pd;
		this.crediti = crediti;
		this.codins = codins;
	}
	
	
	
	
	

}
