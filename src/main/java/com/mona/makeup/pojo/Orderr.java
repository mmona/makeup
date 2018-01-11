package com.mona.makeup.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

import org.apache.catalina.LifecycleListener;

@Entity
public class Orderr {
	private int id;
	private User user;
	private Product product ;
	private int productsum;
	private String  times;
	private int delivery;
	private int reach;
	@Id
	@TableGenerator(name = "PK_GENERATOR_ORDERR", table = "PKGENERATOR", pkColumnName = "TABLENAME", pkColumnValue = "ORDERR", valueColumnName = "PKVALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PK_GENERATOR_ORDERR")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getProductsum() {
		return productsum;
	}
	public void setProductsum(int productsum) {
		this.productsum = productsum;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	@OneToOne
	@JoinColumn(name="productid")
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getReach() {
		return reach;
	}
	public void setReach(int reach) {
		this.reach = reach;
	}
	
}
