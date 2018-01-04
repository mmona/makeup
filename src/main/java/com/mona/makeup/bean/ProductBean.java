package com.mona.makeup.bean;

import com.mona.makeup.pojo.Brand;
import com.mona.makeup.pojo.Type;

public class ProductBean {
	private int id ;
	private String name ;
	private int typeid;
	private String  burden;
	private int  brandid;
	private String description;
	private float price1;
	private int sum1;
	private float price2;
	private int sum2;
	private String imgpath;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getBurden() {
		return burden;
	}
	public void setBurden(String burden) {
		this.burden = burden;
	}
	public int getBrandid() {
		return brandid;
	}
	public void setBrandid(int brandid) {
		this.brandid = brandid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice1() {
		return price1;
	}
	public void setPrice1(float price1) {
		this.price1 = price1;
	}
	public int getSum1() {
		return sum1;
	}
	public void setSum1(int sum1) {
		this.sum1 = sum1;
	}
	public float getPrice2() {
		return price2;
	}
	public void setPrice2(float price2) {
		this.price2 = price2;
	}
	public int getSum2() {
		return sum2;
	}
	public void setSum2(int sum2) {
		this.sum2 = sum2;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	@Override
	public String toString() {
		return "ProductBean [id=" + id + ", name=" + name + ", typeid=" + typeid + ", burden=" + burden + ", brandid="
				+ brandid + ", description=" + description + ", price1=" + price1 + ", sum1=" + sum1 + ", price2="
				+ price2 + ", sum2=" + sum2 + ", imgpath=" + imgpath + "]";
	}
	
}
