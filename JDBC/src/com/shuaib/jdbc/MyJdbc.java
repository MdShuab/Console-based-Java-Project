package com.shuaib.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Load And Register ids done.");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ust?user=root&password=incapp");
			System.out.println("2. Connection is establised.");
		
	 /*   	PreparedStatement pst=con.prepareStatement("insert into ustDetails values(?,?,?)");
			System.out.println("3. Platform is Created.");
			
			pst.setInt(1, 124);
			pst.setString(2,"Ankush");
			pst.setInt(3,1202);
			System.out.println("Data is set.");
			pst.execute();
			pst.setInt(1, 125);
			pst.setString(2,"kaif");
			pst.setInt(3,10020);
			System.out.println("Data is set.");
		    pst.execute();
			pst.setInt(1, 126);
			pst.setString(2,"Ali");
			pst.setInt(3,5020220);
			System.out.println("Data is set.");
			
			pst.execute();
			System.out.println("Executed Query.");  */
			
			
		/*	PreparedStatement p1=con.prepareStatement("Update ustdetails set name=? where id=?");
			p1.setString(1, "khan");
			p1.setInt(2, 126);
			p1.executeUpdate();  */
			
			CallableStatement cst=con.prepareCall("{call ust.insert(?,?,?)}");
			cst.setInt(1, 100);
			cst.setString(2,"saif");
		    cst.setInt(3,30000);
		    cst.execute();
			System.out.println("Executed.");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
