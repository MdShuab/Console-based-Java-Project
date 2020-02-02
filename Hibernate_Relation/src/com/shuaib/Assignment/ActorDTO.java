package com.shuaib.Assignment;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.shuaib.ManyToMany.VendorDTO;
import com.shuaib.ManyToOne.CompanyDTO;
@Entity
public class ActorDTO {
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int aid;
	private String aName;
	private String aType;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="mid")
	private MovieDTO mdto;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="dir_act",joinColumns=@JoinColumn(name="aid"),inverseJoinColumns=@JoinColumn(name="did"))
	private List<DirectorDTO> ldirector;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaType() {
		return aType;
	}

	public void setaType(String aType) {
		this.aType = aType;
	}

	public MovieDTO getMdto() {
		return mdto;
	}

	public void setMdto(MovieDTO mdto) {
		this.mdto = mdto;
	}

	public List<DirectorDTO> getLdirector() {
		return ldirector;
	}

	public void setLdirector(List<DirectorDTO> ldirector) {
		this.ldirector = ldirector;
	}
	
	
	
}
