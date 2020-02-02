package com.shuaib.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class JDBCAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ust?user=root&password=incapp");
			PreparedStatement pst=con.prepareStatement("insert into sDetails values(?,?,?,?,?,?,?)");
			con.setAutoCommit(false);
			pst.setInt(1, 1);
			pst.setString(2, "Shuaib");
			
			pst.setString(3, "cs");
			pst.setInt(4,2019);
			pst.setFloat(5, 75.25f);
			pst.setLong(6, 9555683335l);
			pst.setString(7, "shuaibkhan2028@gmail.com");
			pst.execute();
			
			con.commit();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	   catch (SQLException e) {
			System.out.println("Record Already exist. ");
		}

	}

}
