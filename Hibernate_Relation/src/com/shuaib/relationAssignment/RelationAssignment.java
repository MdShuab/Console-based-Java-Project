package com.shuaib.relationAssignment;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RelationAssignment {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		String name;
		String type;
		System.out.println("Enter 1 to Perform One To One Relation Between Movie And Director.");
		System.out.println("Enter 2 to Perform One To Many Relation Between Director And Movie.");
		System.out.println("Enter 3 to Perform Many To One Relation Between Actor And Movie.");
		System.out.println("Enter 4 to Perform Many To Many Relation Between Actor And Director.");
		
		int ch=sc.nextInt();
		switch (ch) {
			case 1:
//				System.out.println("Enter Director Name.");
//				sc.nextLine();
//				name=sc.nextLine();
//				System.out.println("Enter Director Type(Action or Romantic).");
//				type=sc.nextLine();
//				DirectorDTO ddto=new DirectorDTO();
//				ddto.setdName(name);
//				ddto.setdType(type);
//				
//				MovieDTO mdto=new MovieDTO();
//				System.out.println("Enter Actor Name.");
//				sc.nextLine();
//				name=sc.nextLine();
//				System.out.println("Enter Actor Type(Male or Female).");
//				type=sc.nextLine();
//				mdto.setmName(name);
//				mdto.setmType(type);
//				mdto.setDdto(ddto);
//				ss.save(mdto);
//				ss.beginTransaction().commit();
				
				
				break;
			case 2:
						
						break;
			case 3:
				
				break;
			case 4:
				
				break;

		default:
			break;
		}
		
		ss.close();
		sf.close();

	}

}
