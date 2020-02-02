package com.shuaib.Assignment;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.shuaib.onetoOne.Engine;

@Entity
public class MovieDTO implements Serializable{
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

	public String getmName() {
		return mname;
	}

	public void setmName(String mName) {
		this.mname = mName;
	}

	public String getmType() {
		return mtype;
	}

	public void setmType(String mType) {
		this.mtype = mType;
	}

	public DirectorDTO getDdto() {
		return ddto;
	}

	public void setDdto(DirectorDTO ddto) {
		this.ddto = ddto;
	}
	
	
	
}
