package com.shuaib.hibernateclass;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;



public class StudentDAO {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		
//		
//		Query qry=ss.createQuery("from StudentDTO where id=1");
//		StudentDTO stdto=(StudentDTO) qry.uniqueResult();
//		System.out.println(stdto.getId()+" "+stdto.getName()+" "+stdto.getStream()+" "+stdto.getPercentage());
//		
		//One Record By Criteria
//		Criteria cr=ss.createCriteria(StudentDTO.class);
//		cr.add(Restrictions.eq("id", 1));
//		StudentDTO stdto=(StudentDTO) cr.uniqueResult();
//		System.out.println(stdto.getId()+" "+stdto.getName()+" "+stdto.getStream()+" "+stdto.getPercentage());
		
		//Multiple record access by Criteria
		Criteria cr=ss.createCriteria(StudentDTO.class);
		List<StudentDTO> list=cr.list();
		for(StudentDTO stdto:list) {
			System.out.println(stdto.getId()+" "+stdto.getName()+" "+stdto.getStream()+" "+stdto.getPercentage());
		}
		
	
		
		// List() get all the row
		//1 prepare query
//		Query qry1=ss.createQuery("from StudentDTO");
		//2 process querry
//		List<StudentDTO> list=qry1.list();
//		for(StudentDTO stdto:list) {
//		System.out.println(stdto.getId()+" "+stdto.getName()+" "+stdto.getStream()+" "+stdto.getPercentage());
//										}
//		
		// setParameter() to set the value dynamically like jdbc prepare statement
		
//		Query qry=ss.createQuery("from StudentDTO where id=?");
//		qry.setParameter(0,new Integer(1));
//		StudentDTO stdto=(StudentDTO) qry.uniqueResult();
//		System.out.println(stdto.getId()+" "+stdto.getName()+" "+stdto.getStream()+" "+stdto.getPercentage());
		
	// overload method setParameter() to set the value dynamically like jdbc prepared statement	
		/*
		 * Query qry=ss.createQuery("from StudentDTO where id=:id");
		 * qry.setParameter("id",new Integer(1)); StudentDTO stdto=(StudentDTO)
		 * qry.uniqueResult();
		 * System.out.println(stdto.getId()+" "+stdto.getName()+" "+stdto.getStream()
		 * +" "+stdto.getPercentage());
		 */
		
		//Update
//		Query qry=ss.createQuery("update StudentDTO set percentage=percentage+10");
//		int row=qry.executeUpdate();
//		System.out.println("Row Efected: "+row);
//		
		//Delete
//				Query qry=ss.createQuery("delete from StudentDTO where id=1");
//				int row=qry.executeUpdate();
//				System.out.println("Row Efected: "+row);
//				
		
		//Create Table
		
//		StudentDTO dto=new StudentDTO();
//		dto.setName("GS");
//		dto.setStream("IT");
//		dto.setPercentage(65.2);
//		ss.save(dto);
//		Transaction tx=ss.beginTransaction();
//		tx.commit();

		//Fetch
		/*
		 * StudentDTO dto=ss.load(StudentDTO.class, 3);
		 * System.out.println(dto.getId()+" "+dto.getName()+" "+dto.getStream()+" "+dto.
		 * getPercentage()); ss.save(dto);
		 */
		 
		
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
