package it.polito.tdp.lab3.model;

import java.util.List;

import it.polito.tdp.lab3.db.CorsoDAO;
import it.polito.tdp.lab3.db.StudenteDAO;

public class Model {
	
	private StudenteDAO s = new StudenteDAO();
	private CorsoDAO c = new CorsoDAO();
	

	
	public Studente doCompleta(int matricola){
		
		
		
		return this.s.doCompleta(matricola);
	}
	
	public List<Corso> tuttiICorsi(){
		return this.c.tuttiICorsi();
	}
	public List<Studente> iscrittiCorso(Corso corso){
		return this.c.iscrittiCorso(corso);
	}
	
	public List<Corso> iscrittoCorsi(Integer matricola){
		return this.s.iscrittoCorsi(matricola);
	}
	
	public boolean isIscritto(Integer matricola, String codins){
		return s.isIscritto(matricola, codins);
	}
	
	public boolean doIscrivi(Integer matricola, String codins){
		return c.doIscirvi(codins, matricola);
		
	}
	

}
