package com.shuaib.essPortalApp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class EmpInfoDAO {

	public static void main(String[] args) {


		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		int mch=0;
		
		do {
		Query qry=null;
		Criteria cr;
		EmpInfoDTO dto;
		Scanner sc=new Scanner(System.in);
		System.out.println("Press 1 to Register employee\r\n" + 
				"Press 2 to login");
		int ch=sc.nextInt();
		
		switch(ch) {
		case 1:
			System.out.println("================Welcome To Register Page================");
			System.out.println("Enter Employe Name.");
			sc.nextLine();
			String ename=sc.nextLine();
			System.out.println("Enter Employe Type.");
			String etype=sc.next();
			System.out.println("Enter Employe Email.");
			String em=sc.next();
			System.out.println("Enter Employe Password.");
			String pw=sc.next();
			 dto=new EmpInfoDTO();
			dto.setEname(ename);
			dto.setEtype(etype);
			dto.setEml(em);
			dto.setPw(pw);
			ss.save(dto);
			ss.beginTransaction().commit();
			System.out.println(etype+" Registered Successfully.");
	
			break;
		case 2:
			System.out.println("================Welcome To Login Page================");
			System.out.println("Enter Email.");
			String logem=sc.next();
			System.out.println("Enter Password.");
			String logpw=sc.next();
			qry=ss.createQuery("from EmpInfoDTO where eml='"+logem+"' and pw='"+logpw+"' ");
			dto=(EmpInfoDTO) qry.uniqueResult();
			if(dto!=null) {
				
				System.out.println("Login Success.");
				String etyp=dto.getEtype();
				String eml=dto.getEml();
				int emid=dto.getEid();
				if(etyp.equalsIgnoreCase("Employee")) {
					System.out.println("Press 1 to show all status of leave requests\r\n" + 
							"Press 2 to request for a leave");
					int ech=sc.nextInt();
					switch(ech) {
					case 1:
						System.out.println("================Status Of All Leave Request================");
						dto=ss.load(EmpInfoDTO.class, emid);
						System.out.println("ID:"+dto.getEid()+"\nName:"+dto.getEname()+"\nDegn:"+dto.getEtype()+"\nLeave Date:"+dto.getLdate()+"\nLeave Status:"+dto.getLtatus()+"\nEmail:"+dto.getEml());
						break;
					case 2:
						System.out.println("================Welcome To Leave Request Page================");
						dto=ss.load(EmpInfoDTO.class, emid);
						System.out.println("Enter 1 To request");
						int n=sc.nextInt();
						if(n==1) {
							dto.setLtatus("pending");
							System.out.println("Enter Date of Leave");
							sc.nextLine();
							String ldate=sc.nextLine();
							dto.setLdate(ldate);
							ss.save(dto);
							ss.beginTransaction().commit();
						 System.out.println("Leave Request Send Successfully!");	
						}else {
							System.out.println("Wrong Choice Leave Rejected");
						}
						
						break;
						default:
					System.out.println("Enter Valid choice.");
					}
					
				}
				else if(etyp.equalsIgnoreCase("Manager")) {
					
					System.out.println("Press 1 to show all leave request\r\n" + 
							"Press 2 to Approve/Reject leave request");
					int chh=sc.nextInt();
					switch(chh) {				
					case 1:
						System.out.println("\n\n\n==========Leave Request Details==========");
						System.out.println("\n\n");
						cr=ss.createCriteria(EmpInfoDTO.class);
						cr.add(Restrictions.ne("etype", "manager"));
						List<EmpInfoDTO>elist=cr.list();
						
						System.out.println("Employee_ID                   Leave_Date                   Leave_Status");
						for (EmpInfoDTO empInfoDTO : elist) {
							System.out.println(empInfoDTO.getEid()+"                             "+empInfoDTO.getLdate()+"                             "+empInfoDTO.getLtatus());
						}
						break;
					case 2:
						System.out.println("\n\n\n==========Approve/Reject Leave Request Page==========");
						
						System.out.println("Enter Emp ID.");
						int eid=sc.nextInt();
						System.out.println("Enter Leave Status");
						String lst=sc.next();
						dto=ss.load(EmpInfoDTO.class,eid );
						dto.setLtatus(lst);
						ss.update(dto);
						ss.beginTransaction().commit();
						System.out.println("Leave "+lst+" Successfully.");
						break;
						default:
							System.out.println("Enter Valid Choice.");
					}
					
				}
				else {
					System.out.println("Emp Type Does'nt Exist.");
				}
				
				
				
				
				
			}else {
				System.out.println("Incorrect! Email Id Or Password.");
			}
			
			break;
			default:
				System.out.println("Incorrect Choice.");
				
		}
		
		
		
		ss.close();
		sf.close();
		System.out.println("Enter 1 to Go Main Menu.");
		mch = sc.nextInt();
	}while(mch==1);
	}

}
