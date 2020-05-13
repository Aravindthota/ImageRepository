package org.imageprocessing.mysqldbconnutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionUtils {

	public static Connection getMySQLConnection()
	         throws ClassNotFoundException, SQLException {
	     String hostName = "34.87.255.198";
	     String dbName = "HealthCareDb";
	     String userName = "HealthcareUser";
	     String password = "HealthcareUser";
	     return getMySQLConnection(hostName, dbName, userName, password);
	 }
	  
	 public static Connection getMySQLConnection(String hostName, String dbName,
	         String userName, String password) throws SQLException,
	         ClassNotFoundException {
	    
	     Class.forName("com.mysql.jdbc.Driver");
	  
	     // URL Connection for MySQL:
	     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
	  
	     Connection conn = DriverManager.getConnection(connectionURL, userName,
	             password);
	     System.out.println("check connection 1"+conn);
	     return conn;
	 }
	
	
}
