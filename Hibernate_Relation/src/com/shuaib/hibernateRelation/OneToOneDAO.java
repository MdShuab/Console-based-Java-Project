package com.shuaib.hibernateRelation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDAO {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
	
	Demo2DTO d2=new Demo2DTO();
	d2.setName("Engine");
	
	Demo1DTO d1=new Demo1DTO();
	d1.setName("car");
	d1.setD2(d2);
	ss.save(d1);
	Transaction tx=ss.beginTransaction();
	tx.commit();
	
	
	ss.close();
	sf.close();
	}
	
}
