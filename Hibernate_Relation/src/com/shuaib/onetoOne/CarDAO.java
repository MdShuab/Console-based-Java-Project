package com.shuaib.onetoOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CarDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		
//		Engine e=new Engine();
//		e.setCname("Diamond");
//		e.setType("cng");
		
		Car c =new Car();
//		c.setEn(e);
//		c.setModel("2012");
//		c.setName("Audi");
		Car cr=ss.load(Car.class, 1);
		Engine en=cr.getEn();
		System.out.println(en.getCname());
		//ss.save(c);
		ss.beginTransaction().commit();
		
		ss.close();
		sf.close();
	}

}
