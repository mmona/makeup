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
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.aspectj.internal.lang.annotation.ajcPrivileged;

import com.mysql.jdbc.StreamingNotifiable;

//user表
@Entity
public class User {
	private int id;
	private String  username;
	private String password;
	private String realname;
	private String sex;
	private Integer age;
	private String card;
	private String address;
	private String telephone;
	private String email;
	private String code;
	private Integer status;
	private List<Question> questions = new ArrayList<>();
	private List<Review> reviews = new ArrayList<>();
	private List<Orderr> orderr = new ArrayList<>();
	@Id
	@TableGenerator(name = "PK_GENERATOR_USER", table = "PKGENERATOR", pkColumnName = "TABLENAME", pkColumnValue = "USER", valueColumnName = "PKVALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PK_GENERATOR_USER")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String eamil) {
		this.email = eamil;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@OneToMany(mappedBy="users", fetch = FetchType.EAGER)
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	@OneToMany(mappedBy="users",fetch = FetchType.EAGER)
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
    @OneToMany(mappedBy="user",fetch = FetchType.EAGER)
    public List<Orderr> getMorder() {
		return orderr;
	}
	public void setMorder(List<Orderr> order) {
		this.orderr = order;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", realname=" + realname
				+ ", sex=" + sex + ", age=" + age + ", card=" + card + ", address=" + address + ", telephone="
				+ telephone + ", email=" + email + ", code=" + code + ", status=" + status + ", questions=" + questions
				+ ", reviews=" + reviews + ", order=" + orderr + "]";
	}

	
	
	
}
