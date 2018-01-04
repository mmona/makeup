package com.mona.makeup.bean;

public class BrandBean {
	private int id ;
	private String bname;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "BrandBean [id=" + id + ", bname=" + bname + ", description=" + description + "]";
	}
	
}
