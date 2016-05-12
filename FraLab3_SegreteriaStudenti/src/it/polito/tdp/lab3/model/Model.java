package it.polito.tdp.lab3.model;

import it.polito.tdp.lab3.db.CorsoDAO;
import it.polito.tdp.lab3.db.StudenteDAO;

public class Model {
	
	private StudenteDAO s = new StudenteDAO();
	private CorsoDAO c = new CorsoDAO();
	

	
	public Studente doCompleta(int matricola){
		
		
		
		return this.s.doCompleta(matricola);
	}
	
	

}
