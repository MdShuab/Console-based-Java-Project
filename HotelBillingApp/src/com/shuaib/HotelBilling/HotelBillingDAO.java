package com.shuaib.HotelBilling;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HotelBillingDAO {
	
	
	 public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 Configuration cfg=new Configuration();
		 cfg.configure();
		 SessionFactory sf=cfg.buildSessionFactory();
		 Session ss=sf.openSession();
		
		int ch,j=0;
		double Tprice=0.0;
		int a[]=new int[100];
		Query qry;
		List<HotelBillingDTO>list;
		HotelBillingDTO dto;
		int h;
		do {
		System.out.println("Press 1 to Show  All Food Items.");
		System.out.println("Press 2 to take  order From Customer.");
		System.out.println("Press 3 to Operate on Food Items");
		System.out.println("Press 4 to Generate Bill Of the Day");
		
		ch=sc.nextInt();
		switch(ch) {
		
		case 1:
			 qry=ss.createQuery("from HotelBillingDTO");
			 list=qry.list();
			 System.out.println("=========================================");
			 for(HotelBillingDTO sdto:list) {
				System.out.println(" "+sdto.getId()+".  "+sdto.getFood_name()+"  Rs."+sdto.getPrice());
			 }
			 System.out.println("=========================================");
			 break;
		
		case 2:
			qry=ss.createQuery("from HotelBillingDTO");
			list=qry.list();
			System.out.println("=========================================");
			System.out.println("Blow Foods Item Available");
			
			for(HotelBillingDTO sdto:list) {
				System.out.println(" "+sdto.getId()+".  "+sdto.getFood_name()+"  Rs."+sdto.getPrice());
				}
			
			System.out.println("\nWhat would you like to Order. Do order by Food ID.");
			
			int n=1,i=0;
			j=0;
			while(a[j]!=0) {
				a[j]=0;
				j++;
			}
			while(n!=0&&n==1) {
				System.out.println("Enter Food ID to Order Food.");
				int id=sc.nextInt();
				a[i++]=id;
				System.out.println("Enter 1 to Continue Order OR 0 to End.");
				n=sc.nextInt();
				
			}
			System.out.println("=========================================");
			System.out.println("\n\nYour Order Are:");
			
			 j=0;Tprice=0;
			while(a[j]!=0) {
				dto=ss.load(HotelBillingDTO.class, a[j]);
				System.out.println(" "+dto.getId()+".  "+dto.getFood_name()+"  Rs."+dto.getPrice());
				Tprice+= dto.getPrice();
				j++;
			}   System.out.println("-----------------------------");
		    	//System.out.println("Today Total Bill: Rs."+Tprice);
			break;
		case 3:
			 System.out.println("-----------------------------");
			System.out.println("Press A to Add Food Item.");
			System.out.println("Press B to Remove Food Item.");
			System.out.println("Press C to Modify Food Item.");
		   String ch1=sc.next();
		   switch(ch1)
		   {
		   case "A":
		   case "a":
			   // Insert New Food Item
			   System.out.println("-----------------------------");
			   System.out.println("Enter Food Name.");
				 String food_name=sc.next();
				 System.out.println("Enter Food Price.");
				 double price=sc.nextDouble();
				  dto=new HotelBillingDTO();
				 dto.setFood_name(food_name);
				 dto.setPrice(price);
				 ss.save(dto);
				 ss.beginTransaction().commit();
					
				 System.out.println("Succefully Added Food Item.");
				 break;
			   
		   case "B":
		   case "b":
			 //Delete Food Item
			   qry=ss.createQuery("from HotelBillingDTO");
				list=qry.list();
				System.out.println("=========================================");
				System.out.println("Blow Foods Item Available");
				
				for(HotelBillingDTO sdto:list) {
					System.out.println(" "+sdto.getId()+".  "+sdto.getFood_name()+"  Rs."+sdto.getPrice());
					}
				System.out.println("Enter Food ID Which One Food You Want To Delete.");
			int	fid=sc.nextInt();
			dto=ss.load(HotelBillingDTO.class, fid);
			ss.delete(dto);
			 Transaction tx=ss.beginTransaction();
			System.out.println("Food Item Deleted Successfully!");
			 System.out.println("-----------------------------");
			break;
		   case "C":
		   case "c":
			   //Update Food Item
			   qry=ss.createQuery("from HotelBillingDTO");
				list=qry.list();
				System.out.println("=========================================");
				System.out.println("Blow Foods Item Available");
				
				for(HotelBillingDTO sdto:list) {
					System.out.println(" "+sdto.getId()+".  "+sdto.getFood_name()+"  Rs."+sdto.getPrice());
					}
				System.out.println("Enter Food ID Which One Food You Want To Update.");
			int	ffid=sc.nextInt();
			dto=ss.load(HotelBillingDTO.class, ffid);
			if(dto!=null) {
				System.out.println("What You Want to update\nEnter Any one 'Price Or Food Name'");
				String sch=sc.next();
						if(sch.equalsIgnoreCase("Price")) {
									System.out.println("Enter new price.");
									double pprice=sc.nextDouble();
									dto.setPrice(pprice);
									ss.update(dto);
									 ss.beginTransaction().commit();
									System.out.println("Food Price Updated Success!");
									 System.out.println("-----------------------------");
						         }
						else if(sch.equalsIgnoreCase("food")) {
									
										System.out.println("Enter new Food Name.");
										String nfood_name=sc.next();
										dto.setFood_name(nfood_name);;
										ss.save(dto);
										 ss.beginTransaction().commit();
										System.out.println("Food Name Updated Success!");
										 System.out.println("-----------------------------");
									}
						else
							System.out.println("Enter Valid Choice.");
			    }
			else
				System.out.println("Enter valid id.");
			break;
			   default:
				   System.out.println("Enter Valid Choice.");
		   }
		   break;
		case 4:
			System.out.println("\n\nYour Today Order Were:");
			 j=0;
			while(a[j]!=0) {
				 System.out.println("-----------------------------");
				dto=ss.load(HotelBillingDTO.class, a[j]);
				System.out.println(" "+dto.getId()+".  "+dto.getFood_name()+"  Rs."+dto.getPrice());
				
				j++;
			}   System.out.println("-----------------------------");
		    	System.out.println("Today Total Bill: Rs."+Tprice);
		}
		
		System.out.println("Enter 1 to Go Main Menu.");
		h=sc.nextInt();
		}while(h==1);
		ss.close();
		sf.close();
	 }

}
