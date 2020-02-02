package com.shuaib.spring1;

import org.springframework.stereotype.Component;

@Component
public class Engine1 implements Engine{

	
	String ename1;
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println(ename1+" Is Sarted.");
		
	}

	public String getEname1() {
		return ename1;
	}

	public void setEname1(String ename1) {
		this.ename1 = ename1;
	}

	public String getEname() {
		return ename1;
	}

	public void setEname(String ename) {
		this.ename1 = ename;
	}
	

}
