package dbConnection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.Driver;


public class DBConnectionHandler {

	private static final String url = "jdbc:mysql://localhost:3306/mobiledev";
	private static final String user = "root";
	private static final String pass = "root";
	public DBConnectionHandler() {
		// TODO Auto-generated constructor stub
		
	}
	public Connection getDBConnetion() {
		// TODO Auto-generated method stub
		Connection dbConnection = null;
		/* 1. Load JDBC Driver. */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		/* 2. Connect to bdd */
		try {
			/* 
			 *2.1 Connect to database through getConnection a static method of Driver Manager 
			 */
			dbConnection = DriverManager.getConnection(url, user, pass);
			/* Requests to bdd will be here */
			System.out.println("Database Connection Established");
			return dbConnection;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return dbConnection;
	}
	
}

