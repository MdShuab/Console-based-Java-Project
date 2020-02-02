package com.shuaib.OneToMany;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class One2ManyDAO {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		
		// Create 
		
//		Student s1=new Student();
//		s1.setSname("Shuaib");
//		
//
//		Student s2=new Student();
//		s2.setSname("Ankush");
//		
//
//		Student s3=new Student();
//		s3.setSname("Lucky");
//		
//
//		Student s4=new Student();
//		s4.setSname("Ali");
//		
//		List<Student>list=new LinkedList();
//		list.add(s1);
//		list.add(s2);
//		list.add(s3);
//		list.add(s4);
//
//		Faculty f=new Faculty();
//		f.setName("Azam");
//		f.setList(list);
//		ss.save(f);
//		ss.beginTransaction().commit();
		
		//fetch
//		Faculty f=ss.load(Faculty.class,1);
//		System.out.println("Faculty Name "+f.getName());
//		
//		List<Student>list=f.getList();
//		for(Student s:list)
//		{
//			System.out.println(" Student Name: "+s.getSname());
//		}
		
		//update
		
//		Faculty f=ss.load(Faculty.class,1);
//		f.setName(f.getName()+" Reza");
//		
//		List<Student>list=f.getList();
//		for(Student s:list)
//		{
//			if(s.getSname().equalsIgnoreCase("Shuaib"))
//		s.setSname(s.getSname()+" khan");
//		}
//		ss.update(f);
//		ss.beginTransaction().commit();
		
		//Delete
		Faculty f=ss.load(Faculty.class,1);
		ss.delete(f);
		ss.beginTransaction().commit();
		
		
		ss.close();
		sf.close();
	}

}
