package com.mona.makeup.bean;

public class QuestionBean {
	private int id ;
	private String  content;
	private String times;
	private int userid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "QuestionBean [id=" + id + ", content=" + content + ", times=" + times + ", userid=" + userid + "]";
	}
	
	
}
