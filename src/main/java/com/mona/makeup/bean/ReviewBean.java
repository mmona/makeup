package com.mona.makeup.bean;

import com.mona.makeup.pojo.Question;
import com.mona.makeup.pojo.User;

public class ReviewBean {
	private int id;
	private int questionid;
	private int  userid;
	private String content;
	private String time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "ReviewBean [id=" + id + ", questionid=" + questionid + ", userid=" + userid + ", content=" + content
				+ ", time=" + time + "]";
	}
	
}
