package it.polito.tdp.lab3.db;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectDB {
	
	private final static String jdbcURL ="jdbc:mysql://localhost:8889/iscritticorsi?user=root&password=root";
	
	
	 static private java.sql.Connection connection = null;
	
	
	public java.sql.Connection getConnection(){
		
		if(this.connection != null)
			return this.connection;
	
		
		try {
			this.connection = DriverManager.getConnection(jdbcURL);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return this.connection;
		
	}
	
	
	
	
	

}
