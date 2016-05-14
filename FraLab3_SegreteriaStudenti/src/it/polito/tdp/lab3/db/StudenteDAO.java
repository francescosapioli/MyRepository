package it.polito.tdp.lab3.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import it.polito.tdp.lab3.model.Corso;
import it.polito.tdp.lab3.model.Studente;

public class StudenteDAO {
	
	private ConnectDB cdb = new ConnectDB();
	
	
	public Studente doCompleta(Integer matricola){
		
		Studente s = null;
		java.sql.Connection conn = cdb.getConnection();
		try {
			final String sql = "SELECT nome,cognome FROM studente where matricola=?";
			java.sql.PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				s = new Studente(matricola);
				s.setNome(rs.getString("nome"));
				s.setCognome(rs.getString("cognome"));
				
			}
			
			
			
		
			
		} catch (SQLException e) {
			System.out.println("errore connessione");
			e.printStackTrace();
		}
		
		
		return s;
		
	}
	
	public List<Corso> iscrittoCorsi(Integer matricola){
		LinkedList<Corso> corsi = new LinkedList<Corso>();
		String sql = "select distinct corso.nome from corso, iscrizione where iscrizione.matricola=?";
		try {
			java.sql.PreparedStatement st = cdb.getConnection().prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Corso c = new Corso("");
				c.setNome(rs.getString("nome"));
				corsi.add(c);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return corsi;
		
	}
	
	public boolean isIscritto(Integer matricola, String codins){
		String sql="select * from iscrizione where codins=? and matricola=?";
		try {
			java.sql.PreparedStatement st = cdb.getConnection().prepareStatement(sql);
			st.setString(1, codins);
			st.setInt(2, matricola);
			ResultSet rs = st.executeQuery();
			return rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
