package com.mona.makeup.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.websocket.OnError;

@Entity
public class Question {
	private int id ;
	private String  content;
	private String times;
	private User users;
	private List<Review> reviews= new ArrayList<>();
	@Id
	@TableGenerator(name = "PK_GENERATOR_QUESTION", table = "PKGENERATOR", pkColumnName = "TABLENAME", pkColumnValue = "QUESTION", valueColumnName = "PKVALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PK_GENERATOR_QUESTION")
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
	
	@ManyToOne
	@JoinColumn(name="userid")
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	@OneToMany(mappedBy="question",fetch = FetchType.EAGER)
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	
	
	
}
