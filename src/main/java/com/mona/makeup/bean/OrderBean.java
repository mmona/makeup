package com.mona.makeup.bean;

import java.util.List;
public class OrderBean {
	private int id;
	private int userid;
	private int  productid;
	private int productsum;
	private String  times;
	private int delivery;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
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
	@Override
	public String toString() {
		return "OrderBean [id=" + id + ", userid=" + userid + ", productid=" + productid + ", productsum=" + productsum
				+ ", times=" + times + ", delivery=" + delivery + "]";
	}
	
}
