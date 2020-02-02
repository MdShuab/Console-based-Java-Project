package com.shuaib.Assignment;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.shuaib.OneToMany.Student;
@Entity
public class DirectorDTO {
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int did;
	private String dName;
	private String dType;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="aid")
	private List<ActorDTO>alist;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="dir_act",joinColumns=@JoinColumn(name="did"),inverseJoinColumns=@JoinColumn(name="aid"))
	private List<ActorDTO> lactor;


	public int getDid() {
		return did;
	}


	public void setDid(int did) {
		this.did = did;
	}


	public String getdName() {
		return dName;
	}


	public void setdName(String dName) {
		this.dName = dName;
	}


	public String getdType() {
		return dType;
	}


	public void setdType(String dType) {
		this.dType = dType;
	}


	

	public List<ActorDTO> getAlist() {
		return alist;
	}


	public void setAlist(List<ActorDTO> alist) {
		this.alist = alist;
	}


	public List<ActorDTO> getLactor() {
		return lactor;
	}


	public void setLactor(List<ActorDTO> lactor) {
		this.lactor = lactor;
	}
	
	
	
}
