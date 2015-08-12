package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
	private static String dbSourceUrl = "jdbc:mysql://localhost/cs595fallarm";
	static private Connection homeworkConn;
	//Class.forName("com.mysql.jdbc.Driver");
	static private String userId = "root";
	static private String dbPassword = "mysql";
	
	
	
	
	public static Connection getConnection() throws SQLException {
		if (homeworkConn == null) 
			try {
			   Class.forName("com.mysql.jdbc.Driver");
			    homeworkConn=  DriverManager.getConnection(dbSourceUrl, userId, dbPassword);
			} 
			catch (ClassNotFoundException e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
			} 
			
			
		
		
		return homeworkConn;
	}
	
	public static void shutdown() throws SQLException {
		if (homeworkConn != null) {
			homeworkConn.close();
		}
	}
}

