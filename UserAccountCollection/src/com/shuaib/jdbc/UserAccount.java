package com.shuaib.jdbc;

public class UserAccount implements Comparable{

	int id;
	String name;
	long mob;
	String add;
	String accType;
	double bal;


	

public UserAccount(int id, String name, long mob, String add, String accType, double bal) {
		super();
		this.id = id;
		this.name = name;
		this.mob = mob;
		this.add = add;
		this.accType = accType;
		this.bal = bal;
	}
public int hashCode() {
		
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		
		return this.hashCode()==obj.hashCode();
	}
	
	

	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", name=" + name + ", mob=" + mob + ", add=" + add + ", accType=" + accType
				+ ", bal=" + bal + "]";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.hashCode()-o.hashCode();
	}
}
