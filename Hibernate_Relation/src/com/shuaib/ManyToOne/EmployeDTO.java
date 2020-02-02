package com.shuaib.ManyToOne;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class EmployeDTO implements Serializable{

	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	
	private int eid;
	private String ename;
	private double sal;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="cid")
	private CompanyDTO cdto;


	public int getEid() {
		return eid;
	}


	public void setEid(int eid) {
		this.eid = eid;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public double getSal() {
		return sal;
	}


	public void setSal(double sal) {
		this.sal = sal;
	}


	public CompanyDTO getCdto() {
		return cdto;
	}


	public void setCdto(CompanyDTO cdto) {
		this.cdto = cdto;
	}
	
	
	
	
}
