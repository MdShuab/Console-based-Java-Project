package com.shuaib.studentRegistration;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;







public class LoginHomeDAO {
	int id;
	Scanner sc=new Scanner(System.in);
	
	public void loginHome(int id) {
		this.id=id;
		System.out.println("From Home");
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		StudentDTO dto;
		System.out.println("Enter 1 to Fetch Data.\nEnter 2 to Update Data.\nEnter 3 to Delete Data.");
		int ch =sc.nextInt();
		switch(ch) {
		case 1:
			 dto=ss.load(StudentDTO.class, id);
			System.out.println("REG No. :"+dto.getRegno()+"\nFirst Name: "+dto.getFname()+"\nLast Name: "+dto.getLname()+"\nEmail: "+dto.getEmail()+"\nMonthly Marks: "+dto.getMonthlyMarks()+"\nQuater Marks: "+dto.getQuaterMarks()+"\nAggregate: "+dto.getAggregateMarks()+"\nPassword: "+dto.getPassword());
			ss.save(dto);
			break;
		case 2:
			
			dto=ss.load(StudentDTO.class, id);
			System.out.println("Update Your Email.------------\n Enter Your New Updated Email.");
			String nemail=sc.next();
			dto.setEmail(nemail);
			ss.update(dto);
			Transaction tx1=ss.beginTransaction();
			tx1.commit();
			System.out.println("Email Successfully Updated.\n");
			 dto=ss.load(StudentDTO.class, id);
			System.out.println("REG No. :"+dto.getRegno()+"\nFirst Name: "+dto.getFname()+"\nLast Name: "+dto.getLname()+"\nEmail: "+dto.getEmail()+"\nMonthly Marks: "+dto.getMonthlyMarks()+"\nQuater Marks: "+dto.getQuaterMarks()+"\nAggregate: "+dto.getAggregateMarks()+"\nPassword: "+dto.getPassword());
			ss.save(dto);
			break;
		case 3:
			dto=ss.load(StudentDTO.class, id);
			ss.delete(dto);
			Transaction tx2=ss.beginTransaction();
			tx2.commit();
			System.out.println("Account Deleted Succefully!");
			StDAO sdao=new StDAO();
			sdao.getDetail();
			default:
				System.out.println("Enter Valid Choice.");
		
		}
		ss.close();
		sf.close();
	}

}
