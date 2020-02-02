package com.ust.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmpDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		
		EmpDTO dto=new EmpDTO();
		dto.setId(2);
		dto.setName("kaif");
		dto.setSal(120000.00);
		ss.save(dto);
		
		Transaction tx=ss.beginTransaction();
		tx.commit();
		ss.close();
		sf.close();
	}

}
