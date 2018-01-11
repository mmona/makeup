package com.mona.makeup.pojo;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.swing.text.FlowView.FlowStrategy;

import org.hibernate.dialect.Ingres10Dialect;
import org.hibernate.type.PrimitiveByteArrayBlobType;

@Entity
public class Product {
	private int id ;
	private String name ;
	private Type type;
	private String  burden;
	private Brand brand;
	private String description;
	private float price1;
	private int sum1;
	private float price2;
	private int sum2;
	private String imgpath;
	@Id
	@TableGenerator(name = "PK_GENERATOR_PRODUCT", table = "PKGENERATOR", pkColumnName = "TABLENAME", pkColumnValue = "PRODUCT", valueColumnName = "PKVALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PK_GENERATOR_PRODUCT")
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
	@OneToOne
	@JoinColumn(name="typeid")
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getBurden() {
		return burden;
	}
	public void setBurden(String burden) {
		this.burden = burden;
	}
	@OneToOne
	@JoinColumn(name="brandid")
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
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
                                                 
	
	
}
