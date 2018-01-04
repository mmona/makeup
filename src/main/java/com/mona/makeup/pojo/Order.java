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
import javax.persistence.TableGenerator;

import org.apache.catalina.LifecycleListener;

@Entity
public class Order {
	private int id;
	private User user;
	private List<Product> products =new ArrayList<Product>();
	private int productsum;
	private String  times;
	private int delivery;
	@Id
	@TableGenerator(name = "PK_GENERATOR_ORDER", table = "PKGENERATOR", pkColumnName = "TABLENAME", pkColumnValue = "ORDER", valueColumnName = "PKVALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PK_GENERATOR_ORDER")
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
	@OneToMany(mappedBy="order")
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
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
	
	
}
