package com.shuaib.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		
//		OneToMany
//		CustomerDTO c1=new CustomerDTO();
//		c1.setCname("Shuaib");
//		c1.setcType("Male");
//		
//		CustomerDTO c2=new CustomerDTO();
//		c2.setCname("Shivam");
//		c2.setcType("Male");
//		
//		CustomerDTO c3=new CustomerDTO();
//		c3.setCname("Ankush");
//		c3.setcType("Male");
//		
//		List<CustomerDTO> lCustomer =new ArrayList<CustomerDTO>();
//		lCustomer.add(c1);
//		lCustomer.add(c2);
//		lCustomer.add(c3);
//		
//		VendorDTO vdto=new VendorDTO();
//		vdto.setVname("Amazon");
//		vdto.setvType("E-com");
//		vdto.setLcustomer(lCustomer);
//		
//		ss.save(vdto);
//		
//		ss.beginTransaction().commit();
		
		
//		ManyToOne
		
		VendorDTO vdto1=new VendorDTO();
		vdto1.setVname("Amazon");
		vdto1.setvType("E-com");
		
		VendorDTO vdto2=new VendorDTO();
		vdto2.setVname("Flipkart");
		vdto2.setvType("E-com");
		
		VendorDTO vdto3=new VendorDTO();
		vdto3.setVname("Snapdeal");
		vdto3.setvType("E-com");
		
		List<VendorDTO> lVendorDTO =new ArrayList<VendorDTO>();
		lVendorDTO.add(vdto1);
		lVendorDTO.add(vdto2);
		lVendorDTO.add(vdto3);
		
		CustomerDTO c1=new CustomerDTO();
		c1.setCname("Shuaib");
		c1.setcType("Male");
		c1.setLvendor(lVendorDTO);
		ss.save(c1);
		ss.beginTransaction().commit();
		
		
		ss.close();
		sf.close();

	}

}
