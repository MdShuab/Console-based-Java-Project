package com.shuaib.spring1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car{
	
	String cname;
	@Autowired
	Engine e;
	
//	public Car(Engine e) {
//		
//		
//		this.e = e;
//	}

	public void move() {
		e.start();
		System.out.println(cname+" Car is Moving.");
	}
//	
//	  public String getCname() { return cname; } 
//	  public void setCname(String cname)
//	  {
//		  this.cname = cname; }
//	  public Engine getE() { 
	//	  return e; } 
	//  public void setE(Engine e) { this.e = e; }
	 

}
