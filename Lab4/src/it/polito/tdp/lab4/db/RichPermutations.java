package it.polito.tdp.lab4.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab4.model.RichWord;

public class RichPermutations {
	
	List<RichWord> rp;
	
	private final static String jdbcURL ="jdbc:mysql://localhost:8889/dizionario?user=root&password=root";
	
	
	public List<RichWord> verifieWord(List<String> permutaions){
		rp = new LinkedList<RichWord>();
		
		String sql ="select distinct * from parola where nome=?";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			PreparedStatement st = conn.prepareStatement(sql);
			
			for(String s : permutaions){
				RichWord rw = new RichWord(s);
			    st.setString(1, s);
			    ResultSet rs = st.executeQuery();
			   if(rs.next())
				   rw.setCorrect(true);
			   rp.add(rw);
			   rs.close();
			}
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rp;
	}
	

}
