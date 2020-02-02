package com.shuaib.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shuaib.ManyToOne.CompanyDTO;
import com.shuaib.ManyToOne.EmployeDTO;

public class ManyToOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		
		CompanyDTO cdto=new CompanyDTO();
		cdto.setCname("UST");
		cdto.setType("Software Developer");
		
		EmployeDTO edto1=new EmployeDTO();
		edto1.setEname("Shuaib");
		edto1.setSal(20200);
		edto1.setCdto(cdto);
		
		EmployeDTO edto2=new EmployeDTO();
		edto2.setEname("Shivam");
		edto2.setSal(70000);
		edto2.setCdto(cdto);
		EmployeDTO edto3=new EmployeDTO();
		edto3.setEname("Ali");
		edto3.setSal(50000);
		edto3.setCdto(cdto);
		
		ss.save(edto1);
		ss.save(edto2);
		ss.save(edto3);
		ss.beginTransaction().commit();
		
		ss.close();
		sf.close();
		
		
		

	}

}
