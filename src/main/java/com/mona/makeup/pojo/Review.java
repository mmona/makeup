package com.mona.makeup.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

@Entity
public class Review {
	private int id;
	private Question question;
	private User users;
	private String content;
	private String time;
	@Id
	@TableGenerator(name = "PK_GENERATOR_REVIEW", table = "PKGENERATOR", pkColumnName = "TABLENAME", pkColumnValue = "REVIEW", valueColumnName = "PKVALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PK_GENERATOR_REVIEW")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name ="questionid")
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	@ManyToOne
	@JoinColumn(name="userid")
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
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
	
}
