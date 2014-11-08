package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Othercfg {

	private int id ;
	private String yid;
	private String cfgid;
	private String cfgname;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYid() {
		return yid;
	}
	public void setYid(String yid) {
		this.yid = yid;
	}
	public String getCfgid() {
		return cfgid;
	}
	public void setCfgid(String cfgid) {
		this.cfgid = cfgid;
	}
	public String getCfgname() {
		return cfgname;
	}
	public void setCfgname(String cfgname) {
		this.cfgname = cfgname;
	}
	
	
}
