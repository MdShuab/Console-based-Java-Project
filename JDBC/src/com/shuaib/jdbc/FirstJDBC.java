package com.shuaib.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class FirstJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Savepoint sp=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ust?user=root&password=incapp");
			
			 Statement st=con.createStatement(); 
	        
			 /*
			 boolean b=st.execute("create table emp (id int(10),name varchar(20),salary int(10))");
	        
	        boolean b=st.execute("update into emp values(1,'shuaib',2000)");
	       
	        boolean b=st.execute("update emp set salary=salary+2000 where id=1");
			 
			 Read Operation.
			 ResultSet rs=st.executeQuery("select * from emp");
	        while(rs.next())
	        {
	        	System.out.println(rs.getInt(1)+" "+rs.getString("name")+" "+rs.getInt("salary"));
	        }
			 */
			// By Prepare Statement platform Query Executed.
	      /* PreparedStatement pst=con.prepareStatement("insert into emp values(?,?,?)");
	        pst.setInt(1,3);
	        pst.setString(2,"Ali");
	        pst.setInt(3, 25000);
	        pst.execute();
	        
	        pst.setInt(1,4);
	        pst.setString(2,"kaif");
	        pst.setInt(3, 30000);
	        pst.execute();
	        
	        pst.setInt(1,4);
	        pst.setString(2,"saif");
	        pst.setInt(3, 5000);
	        pst.execute();
	        
	        pst.setInt(1,5);
	        pst.setString(2,"asif");
	        pst.setInt(3, 60000);
	        pst.execute();
	         
	        pst.setInt(1,6);
	        pst.setString(2,"munasif");
	        pst.setInt(3, 70000);
	        pst.execute();
	        */
			
			// By PrepareStatement Query Updated.
			
		//	PreparedStatement pst =con.prepareStatement("update emp set name=? where id=?");
			
		/*	pst.setString(1, "Ankush");
			pst.setInt(2,3);
	        int row=pst.executeUpdate();
	        System.out.println("Row Effected."+row);
	        
	        pst.setString(1, "Khan");
			pst.setInt(2, 1);
		   int rows=pst.executeUpdate();
		
			System.out.println("Rows Effected "+rows);
			*/
			
			// Delete Data from Table By Statement
			
		/*	int row=st.executeUpdate("delete from emp where id=2");
	        System.out.println("Row Effected."+row);  */
			 
	     // Delete Data from Table By PrepareStatement
             
		/*	 PreparedStatement pst=con.prepareStatement("Delete from emp where id=?");
			 pst.setInt(1, 3);
			 pst.executeUpdate();  */
			 
			 //Insert By Using CallableStatement.
		/*	 CallableStatement cst=con.prepareCall("{call ust.insert(?,?,?)}");
			 cst.setInt(1, 30);
			 cst.setString(2, "Azam");
			 cst.setInt(3, 11000);
	         cst.execute();
	         System.out.println("Callable Statement is executed!");
		*/
			 
			 
			// Transaction 
		/*	 con.setAutoCommit(false);
			 st.execute("insert into emp values(26,'Rohit',25000)");
			 System.out.println("Account Is Created.");
			 st.execute("update emp set salary=salary+2000 where id=26");
			 System.out.println("Balance is Deposited.");
			 sp=con.setSavepoint();
			 System.out.println("setSavePoint.");
			 st.execute("update emp set salary=salary-1000 where id=10");
			 System.out.println("Balance Transfer.");
			 st.execute("update emp set salary=salary+70000 where id=jkdj");
			 System.out.println("Query Executed Successfully.");
			 con.commit();
			 System.out.println("Data is Executed.");
			 
			 */
			 
		/*	 st.addBatch("insert into emp values(29,'zayn',52000)");
			 st.addBatch("update emp set salary=salary+100 where salary>1000");
			 st.addBatch("delete from emp where id=4");
			 int arr[]=st.executeBatch();
			 
			 for (int i : arr) {
				System.out.println("Row Effected: "+i);
			}
			*/
			 
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con.rollback(sp);
				System.out.println("Data is Rollback after savepoint.");
				con.commit();
				System.out.println("Data is comitted before savepoint.");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

}
