package com.shuaib.ManyToMany;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class CustomerDTO implements Serializable{
	

	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	
	private int cid;
	private String cname;
	private String cType;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="ven_cus",joinColumns=@JoinColumn(name="cid"),inverseJoinColumns=@JoinColumn(name="vid"))
	private List<VendorDTO> lvendor;


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getcType() {
		return cType;
	}


	public void setcType(String cType) {
		this.cType = cType;
	}


	public List<VendorDTO> getLvendor() {
		return lvendor;
	}


	public void setLvendor(List<VendorDTO> lvendor) {
		this.lvendor = lvendor;
	}
	
	
	

}
