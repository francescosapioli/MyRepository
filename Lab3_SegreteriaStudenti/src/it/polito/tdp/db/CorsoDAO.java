package it.polito.tdp.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab3.model.Corso;
import it.polito.tdp.lab3.model.Studente;

public class CorsoDAO {
	private Corso c = new Corso();
	
	private String jdbcURL ="jdbc:mysql://localhost:8889/iscritticorsi?user=root&password=root";

	public List<Studente> getStudenti(String codins) {
		LinkedList<Studente> stud = new LinkedList<Studente> ();
try {
			
			java.sql.Connection conn = DriverManager.getConnection(jdbcURL);
			
			java.sql.Statement st = conn.createStatement();
			
			String sql = "select distinct studente.matricola, nome, cognome from (studente join iscrizione) where codins=\""+codins+"\"";
			
			ResultSet rs = st.executeQuery(sql);
			
			
			while(rs.next()){//studente trovato
				
				Studente s = new Studente();
				s.setMatricola(rs.getInt("matricola"));
				s.setNome(rs.getString("nome"));
				s.setCognome(rs.getString("cognome"));
				stud.add(s);
				
				
			}
			if(stud.size()>=1)
				return stud;
			
			
			rs.close();
			conn.close();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}

	public void iscriviStudente(Studente s, String codins) {
		
		
try {
			
			java.sql.Connection conn = DriverManager.getConnection(jdbcURL);
			
			java.sql.Statement st = conn.createStatement();
			
			String sql = "insert into iscrizione (matricola, codins) value ('"+s.getMatricola()+"', '"+codins+"')";
			
			ResultSet rs = st.executeQuery(sql);
			
			
			
			
			
			rs.close();
			conn.close();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
	

}
