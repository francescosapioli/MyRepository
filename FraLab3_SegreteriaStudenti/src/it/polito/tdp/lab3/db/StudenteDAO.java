package it.polito.tdp.lab3.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

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

}
