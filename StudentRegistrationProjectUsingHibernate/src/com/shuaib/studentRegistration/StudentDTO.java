package com.shuaib.studentRegistration;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="StudentRegistration")
public class StudentDTO implements Serializable{
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int regno;
	private String fname;
	private String lname;
	private String email;
	private double monthlyMarks;
	private double quaterMarks;
	private double aggregateMarks;
	private String password;
	
	public int getRegno() {
		return regno;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getMonthlyMarks() {
		return monthlyMarks;
	}
	public void setMonthlyMarks(double monthlyMarks) {
		this.monthlyMarks = monthlyMarks;
	}
	public double getQuaterMarks() {
		return quaterMarks;
	}
	public void setQuaterMarks(double quaterMarks) {
		this.quaterMarks = quaterMarks;
	}
	public double getAggregateMarks() {
		return aggregateMarks;
	}
	
	
	public void setAggregateMarks(double aggregateMarks) {
		this.aggregateMarks = aggregateMarks;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
