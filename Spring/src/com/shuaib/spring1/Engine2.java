package com.shuaib.spring1;

public class Engine2 implements Engine{

	
String ename2;
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println(ename2+" Is Sarted.");
	}

	public String getEname2() {
		return ename2;
	}

	public void setEname2(String ename2) {
		this.ename2 = ename2;
	}

	public String getEname() {
		return ename2;
	}

	public void setEname(String ename) {
		this.ename2 = ename;
	}
}
