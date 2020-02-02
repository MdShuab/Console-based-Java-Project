package com.shuaib.phoneApp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class PhoneDAO {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		PhoneDTO dto;
	int ch5;
   do {
		System.out.println("==========Welcome To My Phone APPP=========");
		System.out.println("Press 1 to Show all contacts\r\n" + 
				"Press 2 to Search for contact (using name)\r\n" + 
				"Press 3 to Operate on contact");
		int ch=sc.nextInt();
		
		switch(ch)
		{
		case 1:
			
			Criteria cr=ss.createCriteria(PhoneDTO.class);
			List<PhoneDTO> list=cr.list();
			System.out.println("================================================");
			System.out.println("All Contacts:");
			for(PhoneDTO dto1:list) {
				
				System.out.println("Name: "+dto1.getName()+"| Number: "+dto1.getNum()+"| Group: "+dto1.getGroup());
			}
			
			break;
		case 2:
			// Search Code
			Criteria	cr1=ss.createCriteria(PhoneDTO.class);
			System.out.println("================================================");
			sc.nextLine();
			System.out.println("Enter Name Which You Want to Search.");
			String sn=sc.nextLine();
			cr1.add(Restrictions.ilike("name", sn));
			List<PhoneDTO> list1=cr1.list();
			long num=0;
			String cnam;
			String msg;
			for(PhoneDTO dto1:list1) {
				num=dto1.getNum();
				
				System.out.println("Name: "+dto1.getName()+"| Number: "+dto1.getNum()+"| Group: "+dto1.getGroup());
				
			}
			
			// Search Again
			while(num==0) {
				System.out.println("Contact Does'nt Exist! Search Again.");
				 sn=sc.nextLine();
				 Criteria	cr2=ss.createCriteria(PhoneDTO.class);
				cr2.add(Restrictions.ilike("name", sn));
				List<PhoneDTO>list2=cr2.list();
			
				for(PhoneDTO dto1:list2) {
					num=dto1.getNum();
					System.out.println("num= "+num);
					System.out.println("Name: "+dto1.getName()+"| Number: "+dto1.getNum()+"| Group: "+dto1.getGroup());
					
				}
				
				
				
				
			}
			
			int n=0;
			if(num!=0) {
			do {
				System.out.println("================================================");
			System.out.println("\nPress 1 to call\r\n" + 
					"Press 2 to message\r\n" + 
					"Press 3 to go back to main menu");
			        int os=sc.nextInt();
									switch(os){
										case 1:
											System.out.println("Calling..\nMr./Mrs. "+sn+"\n"+num+"\n\n");
											System.out.println("Enter 1 to Call End.");
											n=sc.nextInt();
											break;
										case 2:
											System.out.println("Write Mssage To Mr./Mrs. "+sn);
											sc.nextLine();
											msg=sc.nextLine();
											System.out.println("Message Sent to Mr./Mrs. "+sn);
											System.out.println(msg);
											System.out.println("Enter 1 To main menu.");
											n=sc.nextInt();
											break;
										case 3:
											main(args);
									}
			
			}while(n==1);
		}else
			System.out.println("================================================\nContact Does'nt Exist!.");
			
			break;
			
		case 3:
			System.out.println("================================================");
System.out.println("Press 1 to add contact\r\n" + 
		"Press 2 to delete contact\r\n" + 
		"Press 3 to edit contact");

     int choice=sc.nextInt();
     switch(choice) {
     
     case 1:
    	 
    	 System.out.println("Enter Name.");
    	 sc.nextLine();
    	 String nm=sc.nextLine();
    	 System.out.println("Enter Number.");
    	 long anum=sc.nextLong();
    	 String numl=String.valueOf(anum);
    	 while(numl.length()!=10) {
    		 System.out.println("Enter Correct 10 Digit Number.");
    		 anum=sc.nextLong();
    		 numl=String.valueOf(anum);
    	 }
    	 System.out.println("Enter Group.");
    	 String gr=sc.next();
    		dto=new PhoneDTO();
    		dto.setName(nm);
    		dto.setNum(anum);
    		dto.setGroup(gr);
    		ss.save(dto);
    		ss.beginTransaction().commit();
 		System.out.println("Contact Successfully Added.");
    	 
    	 break;
    	 
     case 2:
    	 System.out.println("================================================");
    	 System.out.println("All Contacts: ");
    	 Criteria cr2=ss.createCriteria(PhoneDTO.class);
			List<PhoneDTO> list2=cr2.list();
			
			for(PhoneDTO dto2:list2) {
				
				System.out.println("Name: "+dto2.getName()+"| Number: "+dto2.getNum()+"| Group: "+dto2.getGroup());
			}
			System.out.println("-------------------------------------------");
    	 System.out.println("\n Select AnyOne By 'Name' Which Contact You Want To Delete.");
    	
    	 sc.nextLine();
    	 String dnm=sc.nextLine();
    	 int id=0;
    	 Criteria	cr3=ss.createCriteria(PhoneDTO.class);
			cr3.add(Restrictions.ilike("name", dnm));
			List<PhoneDTO> list3=cr3.list();
			
			for(PhoneDTO dto3:list3) {
				id=dto3.getId();
				
			}
			
		PhoneDTO	dtoo=ss.load(PhoneDTO.class,id);
		System.out.println(dtoo.getName());
			ss.delete(dtoo);
			ss.beginTransaction().commit();
    	System.out.println("Contact Deleted Succefully");
    	System.out.println("-------------------------------------------");
    	 System.out.println("Remaining All Contacts: ");
    	 Criteria cr4=ss.createCriteria(PhoneDTO.class);
			List<PhoneDTO> list4=cr4.list();
			
			for(PhoneDTO dto4:list4) {
				
				System.out.println("Name: "+dto4.getName()+"| Number: "+dto4.getNum()+"| Group: "+dto4.getGroup());
			}
			System.out.println("-------------------------------------------");
    	 
    	 break;
    	 
     case 3:
    	 System.out.println("================================================");
    	 System.out.println("All Contacts: ");
    	 Criteria cr5=ss.createCriteria(PhoneDTO.class);
			List<PhoneDTO> list5=cr5.list();
			
			for(PhoneDTO dto5:list5) {
				
				System.out.println("Name: "+dto5.getName()+"| Number: "+dto5.getNum()+"| Group: "+dto5.getGroup());
			}
			System.out.println("-------------------------------------------");
    	 System.out.println("\n Select AnyOne By 'Name' Which Contact You Want To Edit.");
    	
    	 sc.nextLine();
    	 String dnmm=sc.nextLine();
    	 int idd=0;
    	 Criteria	cr6=ss.createCriteria(PhoneDTO.class);
			cr6.add(Restrictions.ilike("name", dnmm));
			List<PhoneDTO> list6=cr6.list();
			
			for(PhoneDTO dto6:list6) {
				idd=dto6.getId();
				
			}
			System.out.println("-------------------------------------------");
			System.out.println("Enter Your New Number.");
			long numm=sc.nextLong();
			 String numl1=String.valueOf(numm);
	    	 while(numl1.length()!=10) {
	    		 System.out.println("Enter Correct 10 Digit Number.");
	    		numm=sc.nextLong();
	    		 numl1=String.valueOf(numm);
	    	 }
			
		PhoneDTO	dto1=ss.load(PhoneDTO.class,idd);
		  dto1.setNum(numm);
			ss.update(dto1);
			ss.beginTransaction().commit();
    	System.out.println("Contact Update Succefully");
   
    	System.out.println("================================================");
    	 break;
    	 
    	 default:
    		 System.out.println("Enter Valid Choice");
    		
     
     }
			
			break;
			
			default:
				System.out.println("Enter Valid Choice.");
		}
		System.out.println("================================================");
		 System.out.println("Enter 1 to Main menu.");
		    ch5=sc.nextInt();
	}while(ch5==1);
		
		
		
		ss.close();
		sf.close();
		
	}

}
