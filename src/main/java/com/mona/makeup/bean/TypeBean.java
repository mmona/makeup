package com.mona.makeup.bean;

public class TypeBean {
	private int id;
	private String tname;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "TypeBean [id=" + id + ", tname=" + tname + ", description=" + description + "]";
	}
	

}
