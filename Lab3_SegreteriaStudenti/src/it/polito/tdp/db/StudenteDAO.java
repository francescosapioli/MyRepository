package it.polito.tdp.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab3.model.Corso;
import it.polito.tdp.lab3.model.Studente;

public class StudenteDAO {
	
	private Studente s = new Studente();
	
	private String jdbcURL ="jdbc:mysql://localhost:8889/iscritticorsi?user=root&password=root";
	
	public Studente setStudente(Integer matricola){
		
		
		
try {
			
			java.sql.Connection conn = DriverManager.getConnection(jdbcURL);
			
			java.sql.Statement st = conn.createStatement();
			
			String sql = "select nome, cognome from studente where matricola=\""+matricola+"\"";
			
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()){//studente trovato
				
				
				s.setMatricola(matricola);
				s.setNome(rs.getString("nome"));
				s.setCognome(rs.getString("cognome"));
				
			}
			
			
			rs.close();
			conn.close();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//studente non trovato
		return null;
	}

	public List<Corso> getCorsi(Integer matricola) {
		
		LinkedList<Corso> corsi = new LinkedList<Corso> ();
		
		
try {
			
			java.sql.Connection conn = DriverManager.getConnection(jdbcURL);
			
			java.sql.Statement st = conn.createStatement();
			
			String sql = "select distinct corso.codins, crediti, nome, pd from corso, iscrizione where corso.codins=iscrizione.codins and iscrizione.matricola=\""+matricola+"\"";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				Corso c = new Corso();
				c.setNome(rs.getString("nome"));
				c.setCodins(rs.getString("codins"));
				c.setCrediti(rs.getInt("crediti"));
				c.setPd(rs.getInt("pd"));
				corsi.add(c);
				
				
			}
			if(corsi.size()>=1)
				return corsi;
			
			
			rs.close();
			conn.close();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}
	
	
	

}
