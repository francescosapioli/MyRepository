package it.polito.tdp.lab3.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab3.model.Corso;
import it.polito.tdp.lab3.model.Studente;

public class CorsoDAO {
	
	private ConnectDB cdb = new ConnectDB();
	
	
	
	public List<Corso> tuttiICorsi(){
		
		List<Corso> corsi = new LinkedList<Corso>();
		
		try {
			Statement st = this.cdb.getConnection().createStatement();
			String sql ="select * from corso";
			ResultSet rs =  st.executeQuery(sql);
			
			
			
			while(rs.next()){
				Corso corso = new Corso("");
				corso.setNome(rs.getString("nome"));
				corso.setCodins(rs.getString("codins"));
				corso.setCrediti(rs.getInt("crediti"));
				corso.setPd(rs.getInt("pd"));
				corsi.add(corso);
				
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return corsi;
	}
	
	public List<Studente> iscrittiCorso(Corso corso){
		
		LinkedList<Studente> stud = new LinkedList<Studente>();
		String sql = "select distinct nome, cognome, studente.matricola, cds from studente, iscrizione where iscrizione.codins=?";
		try {
			PreparedStatement st = cdb.getConnection().prepareStatement(sql);
			st.setString(1, corso.getCodins());
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Studente s = new Studente(0);
				s.setMatricola(rs.getInt("matricola"));
				s.setNome(rs.getString("nome"));
				s.setCognome(rs.getString("cognome"));
				s.setCds(rs.getString("cds"));
				stud.add(s);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stud;
		
	}
	
	public boolean doIscirvi(String codins, Integer matricola){
		boolean flag=false;
		String sql = "insert into iscrizione (matricola, codins) values (?, ?)";
		PreparedStatement st;
		try {
			
			String sql1 = "select * from iscrizione where matricola=? and codins=?";
			st = cdb.getConnection().prepareStatement(sql1);
			st.setInt(1, matricola);
			st.setString(2, codins);
			ResultSet rs = st.executeQuery();
			if(rs.next() == false){
				st = cdb.getConnection().prepareStatement(sql);
				st.setInt(1, matricola);
				st.setString(2, codins);
				st.execute();
				
				String sql2 = "select * from iscrizione where matricola=? and codins=?";
				st = cdb.getConnection().prepareStatement(sql2);
				st.setInt(1, matricola);
				st.setString(2, codins);
				ResultSet rs1 = st.executeQuery();
				if(rs1.next())
					flag=true;
				
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return flag;
		
		
	}
	
	

}
