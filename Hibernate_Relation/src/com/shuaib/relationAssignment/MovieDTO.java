package com.shuaib.relationAssignment;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.shuaib.Assignment.DirectorDTO;

@Entity
public class MovieDTO {

	
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int mid;
	private String mname;
	private String mtype;
	
	@OneToOne(cascade=CascadeType.ALL)
	private DirectorDTO ddto;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public DirectorDTO getDdto() {
		return ddto;
	}

	public void setDdto(DirectorDTO ddto) {
		this.ddto = ddto;
	}
	
	
}
