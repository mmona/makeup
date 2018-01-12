package com.mona.makeup.dao;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mona.makeup.page.utils.Page;
import com.mona.makeup.pojo.Brand;
import com.mona.makeup.pojo.Product;

@Repository
public class ProductDao extends CommonDao {
	//count product
	public int countProduct(){
		String sql="select count(*) from Product";
		List<Object> query = (List<Object>) this.query(sql);
		Number number = (Number) query.get(0);
		return number.intValue();
	}
	//list product
	public List<Product> selectProduct(Page page){
		List<Product> query = this.query(Product.class, page.getBeginIndex(), page.getPageSize());
		if(query!=null&&!query.isEmpty()){
			return query;
		}
		return null;
	}
	//select product by id 
	public Product selectProductById(int id){
		Product product = this.get(Product.class, id);
		if(product!=null){
			return product;
		}
		return null;
	}
	//update product
	@Transactional
	public boolean updateProduct(Product product){
		boolean update = this.update(product);
		return update;
	}
	//delete product 
	@Transactional
	public boolean deleteProduct(int id){
		return this.delete(id, Product.class);
	}
	//add product
	@Transactional
	public boolean addProduct(Product product){
		return this.save(product);
	}
}
