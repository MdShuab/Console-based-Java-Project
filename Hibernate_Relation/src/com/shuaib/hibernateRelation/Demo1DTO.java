package com.shuaib.hibernateRelation;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Demo1DTO implements Serializable {
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int id;
	private String name;
	@OneToOne(cascade=CascadeType.ALL)
	private Demo2DTO d2;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Demo2DTO getD2() {
		return d2;
	}
	public void setD2(Demo2DTO d2) {
		this.d2 = d2;
	}
	
	
	

}
