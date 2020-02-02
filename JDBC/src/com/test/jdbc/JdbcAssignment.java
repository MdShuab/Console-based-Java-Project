package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JdbcAssignment {

	public static void main(String[] args) {
		
		// Registration with Email Validation.
		
		
		int ch,chh,chhh;
        int sid;
        String sname;
        String sstream;
        int syop;
        String sdob;
        long smob;
        String semail=null;
        StringTokenizer st=null;
		Scanner sc=new Scanner(System.in);
		do{
		System.out.println("Enter 1 to Register.");
		System.out.println("Enter 2 to LogIn.");
		 chh=sc.nextInt();
		 switch(chh){
		 case 1:
		do{
		System.out.println("Enter Details of Student.");
		System.out.println("Enetr id.");
		sid=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Name.");
		sname=sc.nextLine();
		System.out.println("Enter Stream.");
		sstream=sc.nextLine();
		System.out.println("Enter Year of passing.");
		syop=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter DOB (yyyy-mm-dd).");
		sdob=sc.nextLine();
		
		System.out.println("Enter Mobile Number.");
		String mobile=sc.nextLine();
						while(mobile.length()!=10)
						{   
							System.out.println("Enter Valid 10 Digit No.");
							mobile =sc.nextLine();
						}
		smob=Long.parseLong(mobile);
		
		System.out.println("Enter Email ID.");
		
		String temEmail=sc.nextLine();
	    st=new StringTokenizer(temEmail, "@");
	   int  len=st.countTokens();
	    String str;
	    
	    while(len!=2)
		  {
			 System.out.println("Enter valid Email id."); 
			 temEmail=sc.nextLine();
			 st=new StringTokenizer(temEmail, "@");
			 len=st.countTokens();
		  }
		 
		do{
				        st.nextToken();
				        str=st.nextToken();
					  if(str.equalsIgnoreCase("gmail.com"))
					   { 
						   semail=temEmail;
						   break;
					   }
					  else if(str.equalsIgnoreCase("yahoo.com"))
					   { 
						   semail=temEmail;
						   break;
					   }
					  else
					    { 
                         System.out.println("Enter Valid Email id.");
					     temEmail=sc.nextLine();
						 st=new StringTokenizer(temEmail, "@");
						 len= st.countTokens();    
					    }
					  
				  while(len!=2)
				  {  
					 System.out.println("Enter valid Email id."); 
					 temEmail=sc.nextLine();
					 st=new StringTokenizer(temEmail, "@");
					 len= st.countTokens();
					 
				  }
			} 
	  while(str!="gmail.com");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ust?user=root&password=incapp");
			con.setAutoCommit(false);
			PreparedStatement pst=con.prepareStatement("insert into studdetails values(?,?,?,?,?,?,?)");
			pst.setInt(1, sid);
			pst.setString(2, sname);
			pst.setString(3,sstream);
			pst.setInt(4, syop);
			pst.setString(5, sdob);
			pst.setLong(6, smob);
			pst.setString(7, semail);
			
   
		  
			
			pst.execute();
			con.commit();
			System.out.println("Registered Successfully!");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("User Already Exist!");
		}
		
		System.out.println("Enter 1 to Register new Student.");
		 ch =sc.nextInt();
		} while(ch==1);
		 break;
		 
		 case 2:
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ust?user=root&password=incapp");
					
					 int ssid;
			           String ssname;
			            sc=new Scanner(System.in);
			           System.out.println("Enter id");
			           ssid=sc.nextInt();
			           sc.nextLine();
			           System.out.println("Enter Name.");
			          ssname=sc.nextLine();
					
					Statement stt=con.createStatement();
					ResultSet rs;
				    rs=stt.executeQuery("select * from studdetails where id='"+ssid+"' and name='"+ssname+"' " );
					
					
				  while(!rs.next())
					{   
					  System.out.println("Enter Valid 'ID' or 'NAME'.");
			           sid=sc.nextInt();
			           sc.nextLine();
			           System.out.println("Enter Name.");
			           sname=sc.nextLine();
					   rs.previous();
					   
						
					        rs=stt.executeQuery("select * from studdetails where id='"+sid+"' and name='"+sname+"' " );
						 
					   
					}
				  System.out.println("ID: "+rs.getInt(1)+" "+"NAME: "+rs.getString(2)+" "+"STREAM: "+rs.getString(3)+" "+"YOP: "+rs.getInt(4)+" "+"DOB: "+rs.getDate(5)+" "+"MOB: "+rs.getLong(6)+" "+"EMAIL: "+rs.getString(7));
					
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
           default:
        	   System.out.println("Enter Valid Choice.");
		 }
		 System.out.println();
		 System.out.println("Enter 1 to Go HomePage.");
		  chhh=sc.nextInt();
		}while(chhh==1);
	}
    
}
