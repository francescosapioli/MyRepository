package it.polito.tdp.spellchecker.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class DictionaryDB{
	
	
	private String jdbcURL ="jdbc:mysql://localhost:8889/dizionario?user=root&password=root";
	
	
	public List<String> loadDictionaryFromDB(){
		List<String> words = new LinkedList<String>();
		
		
		
		try {
			
			java.sql.Connection conn = DriverManager.getConnection(jdbcURL);
			
			java.sql.Statement st = conn.createStatement();
			
			String sql = "select nome from parola";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				words.add(rs.getString("nome"));
			}
			rs.close();
			conn.close();
			
			return words;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
		
	}
	
	

}
