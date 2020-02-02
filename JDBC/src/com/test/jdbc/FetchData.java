package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FetchData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           int sid;
           String sname;
           Scanner sc=new Scanner(System.in);
           System.out.println("Enter LogIn id And Name.");
           sid=sc.nextInt();
           sc.nextLine();
           System.out.println("Enter Name.");
           sname=sc.nextLine();
           
           
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ust?user=root&password=incapp");
			
			Statement st=con.createStatement();
			ResultSet rs;
		    rs=st.executeQuery("select * from studdetails where id='"+sid+"' and name='"+sname+"' " );
			
			
		  while(!rs.next())
			{   
			  System.out.println("Enter Valid 'ID' or 'NAME'.");
	           sid=sc.nextInt();
	           sc.nextLine();
	           System.out.println("Enter Name.");
	           sname=sc.nextLine();
			   rs.previous();
			   
				
			        rs=st.executeQuery("select * from studdetails where id='"+sid+"' and name='"+sname+"' " );
				 
			   
			}
		  System.out.println("ID: "+rs.getInt(1)+" "+"NAME: "+rs.getString(2)+" "+"STREAM: "+rs.getString(3)+" "+"YOP: "+rs.getInt(4)+" "+"DOB: "+rs.getDate(5)+" "+"MOB: "+rs.getLong(6)+" "+"EMAIL: "+rs.getString(7));
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
