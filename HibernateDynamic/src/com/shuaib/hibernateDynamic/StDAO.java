package com.shuaib.hibernateDynamic;

import java.lang.reflect.Method;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StDAO {

	
	public static void getData() {
		Scanner sc=new Scanner(System.in);
		int id,i;
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		do {
		System.out.println("Enter 1 to Enter Data.\nEnter 2 to Fetch Data.\nEnter 3 to Update Data.\nEnter 4 to Delete Data.");
		int ch =sc.nextInt();
		
		switch(ch) {
		case 1:
			System.out.println("Enter Name");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.println("Enter Course");
			String course=sc.next();
			System.out.println("Enter Stream");
			String stream=sc.next();
			System.out.println("Enter Email");
			String email=sc.next();
			System.out.println("Enter Contact");
			long mob=sc.nextLong();
				StDetailDTO dto1=new StDetailDTO();
				dto1.setName(name);
				dto1.setCourse(course);
				dto1.setStream(stream);
				dto1.setEmail(email);
				dto1.setContact(mob);
				ss.save(dto1);
				Transaction tx=ss.beginTransaction();
				tx.commit();
				System.out.println("Succefully Inserted!");
				break;
		case 2:
			System.out.println("Enter ID which You want Fetch Data.");
			id=sc.nextInt();
			StDetailDTO dto2=ss.load(StDetailDTO.class, id);
			System.out.println(dto2.getId()+" "+dto2.getName()+" "+dto2.getCourse()+" "+dto2.getStream()+" "+dto2.getEmail()+" "+dto2.getContact());
			ss.save(dto2);
			break;
		case 3:
			System.out.println("Enter ID which You want to Update Data.");
			id=sc.nextInt();
			StDetailDTO dto3=ss.load(StDetailDTO.class, id);
			dto3.setCourse("MBA");
			ss.update(dto3);
			Transaction tx1=ss.beginTransaction();
			tx1.commit();
			
			break;
		case 4:
			System.out.println("Enter ID which You want to Delete Data.");
			id=sc.nextInt();
			StDetailDTO dto4=ss.load(StDetailDTO.class, id);
			ss.delete(dto4);
			Transaction tx2=ss.beginTransaction();
			tx2.commit();
			break;
			default:
				System.out.println("Enter Valid Choice");
		
		}
		System.out.println("Enter 1 to Go Home.");
		i=sc.nextInt();
		}while(i==1);
		
		
	}
	
	
}
