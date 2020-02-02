package com.shuaib.jdbc;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class TestUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int id;
		String name;
		long mob;
		String add;
		String accType;
		double bal;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Account No. ");
		id=sc.nextInt();
		System.out.println("Enter the  Acoount Holder Name. ");
		name=sc.next();
		System.out.println("Enter the Mobile No. ");
		mob=sc.nextLong();
		System.out.println("Enter the Account Holder Address. ");
		add=sc.next();
		System.out.println("Enter the Account Type. ");
		accType=sc.next();
		System.out.println("Enter Initial Balance.");
		bal=sc.nextDouble();
		
		UserAccount u1=new UserAccount(id, name, mob, add, accType, bal);
		
		System.out.println();
		System.out.println();
		
		System.out.println("Create Second Account Enter Details.");
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter the Account No. ");
		id=sc1.nextInt();
		System.out.println("Enter the  Acoount Holder Name. ");
		name=sc1.next();
		System.out.println("Enter the Mobile No. ");
		mob=sc1.nextLong();
		System.out.println("Enter the Account Holder Address. ");
		add=sc1.next();
		System.out.println("Enter the Account Type. ");
		accType=sc1.next();
		System.out.println("Enter Initial Balance.");
		bal=sc.nextDouble();
		
		UserAccount u2=new UserAccount(id, name, mob, add, accType, bal);
		
		TreeSet t=new TreeSet();
		t.add(u1);
		t.add(u2);
		
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("1.Account Created and Added Successfully!");
		
		System.out.println();
		System.out.println();
		
		
		Iterator it=t.iterator();
		while(it.hasNext()){
			Object el=it.next();
			System.out.println(el);
			
		}
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("2. Update Existing Account.");
		System.out.println("Enter which Account no. Details you want to update.");
		int ddid=sc.nextInt();
		Iterator it1=t.iterator();
		while(it1.hasNext())
		{
			Object ob=it1.next();
			UserAccount ur=(UserAccount)ob;
			if(ur.id==ddid){
				System.out.println("What you want to update.? You can update only Name, Mobile Number And Address. Choose one.");
				String ch=sc.next();
				if(ch.equalsIgnoreCase("name")){
					System.out.println("Enter New Name.");
					String nm=sc.next();
					ur.name=nm;
					System.out.println("After Name. Updated.");
					   System.out.println(ur);
				}
				else if(ch.equalsIgnoreCase("mobile")){
					System.out.println("Enter New Mobile No.");
					long mb=sc.nextLong();
					ur.mob=mb;
					System.out.println("After Mobile No. Updated.");
				   System.out.println(ur);
				}
				else if(ch.equalsIgnoreCase("address")){
					System.out.println("Enter New Address.");
					String ad=sc.next();
					ur.add=ad;
					System.out.println("After Address Updated.");
				   System.out.println(ur);
				}
					
			}
			
			
			
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("Which Account You Want delete. Enter Account Number.");
		int idd=sc.nextInt();
		Iterator it2=t.iterator();
		while(it2.hasNext()){
			
			Object el=it2.next();
			UserAccount ur=(UserAccount)el;
			
			if(idd==ur.id)
			{
				System.out.println("This Account Has been Deleted.");
				System.out.println(ur);
			  t.remove(ur);	
			  break;
			}
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("After Delete Remaining Account List.");
		for (Object object : t) {
			System.out.println(object);
		}
		
		
		
		System.out.println();
		System.out.println();
		
		System.out.println("Which Account You Want Search. Enter Account Number.");
		int idd1=sc.nextInt();
		Iterator it3=t.iterator();
		while(it3.hasNext()){
			
			Object el=it3.next();
			UserAccount ur=(UserAccount)el;
			
			if(idd1==ur.id)
			{
				System.out.println("Searched Account.");
				System.out.println(ur);
			  
			  
			}
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("In Which Account You Want Deposite. Enter Account Number.");
		int idd2=sc.nextInt();
		Iterator it4=t.iterator();
		while(it4.hasNext()){
			
			Object el=it4.next();
			UserAccount ur=(UserAccount)el;
			
			if(idd2==ur.id)
			{
				System.out.println("Enter Ammount how much you want deposite.");
				double balance=sc.nextDouble();
				System.out.println("Ammount Before Deposite Money.");
				System.out.println(ur);
				System.out.println();
				System.out.println("After Deposite Money.");
			     
				ur.bal+=balance;
				
				System.out.println(ur);
			  
			}
			else 
				System.out.println("Account no. does'nt exist.");
		}
		
		
		System.out.println();
		System.out.println();
		
		System.out.println("In Which Account You Want Withdraw. Enter Account Number.");
		int idd3=sc.nextInt();
		Iterator it5=t.iterator();
		while(it5.hasNext()){
			
			Object el=it5.next();
			UserAccount ur=(UserAccount)el;
			
			if(idd3==ur.id)
			{
				System.out.println("Enter Ammount how much you want Withdraw.");
				double balance=sc.nextDouble();
				System.out.println("Ammount Before Withdraw Money.");
				System.out.println(ur);
				System.out.println();
				System.out.println("After After Withdraw Money.");
			     if(ur.bal>balance){
				ur.bal-=balance;
				System.out.println(ur);
			     }
			     else
			    	 System.out.println("Insufficient! balance in Your ACCOUNT.");
			  
			}
		}
	}

}
