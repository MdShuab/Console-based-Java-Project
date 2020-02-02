package com.shuaib.studentRegistration;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StDAO {
	Double monthlyMarks=0.0;
	Double quaterMarks=0.0;
	public void getDetail() {
		
		Scanner sc=new Scanner(System.in);
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		System.out.println("Enter 1 to Register.\nEnter 2 to Login.");
		int ch=sc.nextInt();
		StudentDTO dto=new StudentDTO();
		switch(ch) {
		
		
		case 1:
			System.out.println("Enter First Name.");
			String fname=sc.next();
			dto.setFname(fname);
			System.out.println("Enter Last Name.");
			String lname=sc.next();
			dto.setLname(lname);
			System.out.println("Enter Email.");
			String email=sc.next();
			dto.setEmail(email);
			System.out.println("Enter Monthly Marks.");
			 monthlyMarks=sc.nextDouble();
			dto.setMonthlyMarks(monthlyMarks);
			System.out.println("Enter Quater Marks.");
			 quaterMarks=sc.nextDouble();
			dto.setQuaterMarks(quaterMarks);
			
			double aaggregateMarks=(((monthlyMarks/12)+(quaterMarks/4))/2.0);
			dto.setAggregateMarks(aaggregateMarks);
			System.out.println("Enter Password.");
			String password=sc.next();
			dto.setPassword(password); 
			ss.save(dto);
			Transaction tx=ss.beginTransaction();
			tx.commit();
			System.out.println("Registration Successfully Done!\n------------------------------");
			
		case 2:
			System.out.println("-----------------------------------------");
			System.out.println("Welcome To LogiN.");
			 System.out.println("Enter Email.");
			 String lemail=sc.next();
			 System.out.println("Enter Password.");
			 String pass=sc.next();
				Query qry=ss.createQuery("from StudentDTO where email='"+lemail+"' and password='"+pass+"'");
				StudentDTO rs=(StudentDTO) qry.uniqueResult();
				
				
				if(rs!=null) {
					int id=rs.getRegno();
					System.out.println("Login Successful.");
					LoginHomeDAO lh=new LoginHomeDAO();
					lh.loginHome(id);
					
				}
				else {
					System.out.println("Enter Correct Email or Password.");
				}
				
			 
		}
		
		ss.close();
		sf.close();

	}
	
}
