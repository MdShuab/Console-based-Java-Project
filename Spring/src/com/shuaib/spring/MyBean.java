package com.shuaib.spring;

public class MyBean {
	int id;
	String name;
	
	public MyBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	void m1() {
		
		System.out.println("MyBean Obj m1() executed.");
		System.out.println(id+" "+name);
	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
	

}
