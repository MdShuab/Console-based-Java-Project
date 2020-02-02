package com.shuaib.gmailApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GmailApp {

	public static void main(String[] args) {
		
		int choice=0;
		int L=0;
		do {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 to Login.");
		System.out.println("Enter 2 to Registration.");
		int ch=sc.nextInt();
		
		
		
		switch(ch) {
		
		case 1:{
			System.out.println("Enter Email");
			String email=sc.next();
			System.out.println("Enter Password");
			String pass=sc.next();
			
			
			try {
				
				int uid;
				Class.forName("com.mysql.jdbc.Driver");
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail?user=root&password=incapp");
				 Statement st=con.createStatement(); 
				 ResultSet rs=st.executeQuery("select * from account where email='"+email+"' and password='"+pass+"'");
			   
			    	
			    if(rs.next()) 
			    	   {
			    	 uid= rs.getInt(1);
			    	   do {
			    	    System.out.println("Login Success.");
			        	System.out.println("Enter 1 to Compose.");
			    		System.out.println("Enter 2 to Inbox.");
			    		int ch1=sc.nextInt(); 
			    		
			    		switch(ch1) {
			    		
			    		case 1:{ 	     
			    			
			    				System.out.println("Enter Email");
			    			
			    			String cemail=sc.next();
			    			int cid;
			    		     ResultSet rs2=st.executeQuery("select * from account where email='"+cemail+"' ");
			    		  
			    		 if(rs2.next()) {
			    			 cid= rs2.getInt(1);
			    			 System.out.println("Write Message");
			    			sc.nextLine();
			    			 String msg=sc.nextLine(); 
			    			PreparedStatement pst=con.prepareStatement("insert into inbox (user_id,message) values(?,?)");
			    			pst.setInt(1, cid);
			    			pst.setString(2, msg);
			    			pst.execute();
			    			System.out.println("Message Sent.");
			    		  }
			    		   


			    		}
			    		break;
			    		case 2:{
			    			
			    			int cid;
				        	ResultSet rs3=st.executeQuery("select * from account where email='"+email+"' ");
				 	      if(rs3.next()) {
				 	    	  
				 	    	 cid =rs3.getInt(1);
				 	    	
				 	    	 
				 	    		ResultSet rs4= st.executeQuery("select * from inbox where user_id='"+cid+"'");
					 		System.out.println("All Mails.");
				 	    		while(rs4.next()) {
					 			System.out.println(rs4.getInt(1)+". "+rs4.getString(3));
					 		 }
				 	      }
			    			
			    		}
			    		break;
			    		
			    		default:
			    	System.out.println("Enter Valid Choice");		
			    		
			    		}
			    	  System.out.println("Enter 1 to Home Profile"); 
			    	   choice=sc.nextInt();
			    	   }while(choice==1);
			    	 }
			       else {
			    	   System.out.println("Incorect Mail or Id");
			    	   
			    	  
			       }
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		break;
		case 2:{
			
			System.out.println("Enter Name");
			String name=sc.next();
			System.out.println("Enter password ");
			String pass=sc.next();
			System.out.println("Enter Email");
			String email=sc.next();
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				 Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/gmail?user=root&password=incapp");
		 		   
				 PreparedStatement pst=con1.prepareStatement("insert into account (user_name,password,email) values(?,?,?)");
					pst.setString(1, name);
					pst.setString(2, pass);
					pst.setString(3, email);
					pst.execute();
					System.out.println("Register Success!");
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		break;
		default:
			System.out.println("Enter Valid Choice");
		
		}
		sc.next();
		System.out.println("Enter 1 to Logout.");
		L=sc.nextInt();

		
		}while(L==1);
		
	}

}
