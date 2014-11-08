package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Otheryear {

	private int id ;
	private String cid;
	private String yearid;
	private String yearname;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getYearid() {
		return yearid;
	}
	public void setYearid(String yearid) {
		this.yearid = yearid;
	}
	public String getYearname() {
		return yearname;
	}
	public void setYearname(String yearname) {
		this.yearname = yearname;
	}

	
	
}
