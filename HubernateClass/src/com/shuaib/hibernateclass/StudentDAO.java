package com.shuaib.hibernateclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class StudentDAO {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		
		//Create Table
		
//		StudentDTO dto=new StudentDTO();
//		dto.setName("GS");
//		dto.setStream("IT");
//		dto.setPercentage(65.2);
//		ss.save(dto);
//		Transaction tx=ss.beginTransaction();
//		tx.commit();

		//Fetch
		 StudentDTO dto=ss.load(StudentDTO.class, 3);
		 System.out.println(dto.getId()+" "+dto.getName()+" "+dto.getStream()+" "+dto.getPercentage());
		 ss.save(dto);
		 
		
		//Update
		/*
		 * StudentDTO dto=ss.load(StudentDTO.class, 1); dto.setPercentage(80.22);
		 * ss.update(dto); Transaction tx=ss.beginTransaction(); tx.commit();
		 */
		
		//Delete
		
		
		/*
		 * StudentDTO dto=ss.load(StudentDTO.class, 1); ss.delete(dto); Transaction
		 * tx=ss.beginTransaction(); tx.commit();
		 */
		 
		
		
			ss.close();
			sf.close();

	}

}
