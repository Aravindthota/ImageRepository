package org.imageprocessing.utils;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.imageprocessing.beans.PatientDetails;
import org.imageprocessing.mysqldbconnutils.MySQLConnectionUtils;

public class DBUtils {

	 public static PatientDetails findUser(Connection conn,
	            String userName, String password) throws SQLException, ClassNotFoundException {
	 System.out.println("check logged values"+userName+password);
	        String sql = "Select a.FirstName, a.Password, a.Gender from PatientDetails a "
	        			+ " where a.FirstName = ? and a.Password= ?";	
	        if(conn == null){
	        	 System.out.println("entered conn check");
	        	conn=MySQLConnectionUtils.getMySQLConnection();
	      
	            }
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setString(1, userName);
	        pstm.setString(2, password);
	        ResultSet rs = pstm.executeQuery();
	 
	        if (rs.next()) {
	            String gender = rs.getString("Gender");
	            PatientDetails user = new PatientDetails();
	            user.setFirstName(userName);
	            user.setPassword(password);
	            user.setGender(gender);
	            System.out.println("check logged values1"+user.getFirstName());
	            return user;
	        }
	        return null;
	    }
	 
	    public static Boolean validatePatient(Connection conn, String email, String phone) throws SQLException, ClassNotFoundException {
	 
	        String sql = "Select a.FirstName, a.PhoneNumber, a.EmailAddress from PatientDetails a "
        			+ " where a.EmailAddress = ? and a.PhoneNumber= ?";
	        
	        if(conn == null){
	        	 System.out.println("entered conn check");
	        	conn=MySQLConnectionUtils.getMySQLConnection();
	      
	            }
	 
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setString(1, email);
	        pstm.setString(2, phone);
	 
	        ResultSet rs = pstm.executeQuery();
	 
	        if (rs.next()) {
	        	System.out.println("true registered");
	            return true;
	        }
	        return false;
	    }
	 
	    public static void insertPatientDetails(Connection conn, PatientDetails patient) throws SQLException, ClassNotFoundException, FileNotFoundException {
	    	String sql = "Insert into PatientDetails(FirstName,LastName,DateOfBirth,Gender,Password,Address,EmailAddress,Image,PhoneNumber) values (?,?,?,?,?,?,?,?,?)";
	    	
	    	if(conn == null){
	        	 System.out.println("entered conn check");
	        	conn=MySQLConnectionUtils.getMySQLConnection();
	      
	            }
	        PreparedStatement pstm = conn.prepareStatement(sql);
	 
	        pstm.setString(1, patient.getFirstName());
	        pstm.setString(2, patient.getLastName());
	        pstm.setString(3, patient.getDob());
	        pstm.setString(4, patient.getGender());
	        pstm.setString(5, patient.getPassword());
	        pstm.setString(6, patient.getAddress());
	        pstm.setString(7, patient.getEmail());
	        pstm.setString(8, patient.getBase64Image());
	        pstm.setString(9, patient.getMobile());
	        pstm.executeUpdate();
	    }
	    
	    
}
