package it.polito.tdp.lab3.model;

import java.util.List;

import it.polito.tdp.db.CorsoDAO;

public class Corso {
	
	private String nome;
	private String codins;
	private Integer crediti;
	private Integer pd;
	private List<Studente> studenti;
	
	private CorsoDAO c = new CorsoDAO();
	
	
	public List<Studente> getStudenti() {
		this.studenti = c.getStudenti(this.codins);
		return studenti;
	}
	
	public boolean studenteIscritto(Studente s){
		this.getStudenti();
		if(this.studenti.contains(s))
			return true;
		return false;
	}
	
	
	public void iscriviStudente(Studente s){
		this.studenti.add(s);
		c.iscriviStudente(s,this.codins);
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setStudenti(List<Studente> studenti) {
		
	}

	public void setCodins(String codins) {
		this.codins = codins;
	}

	public void setCrediti(Integer crediti) {
		this.crediti = crediti;
	}

	public void setPd(Integer pd) {
		this.pd = pd;
	}
	
	
	
	

}
