package com.mona.makeup.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.hibernate.engine.jdbc.spi.ResultSetReturn;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mona.makeup.page.utils.Page;
import com.mona.makeup.pojo.Brand;
import com.mona.makeup.pojo.Product;
import com.mona.makeup.pojo.Type;

@Repository
public class ProductDao extends CommonDao {
	//count product
	public int countProduct(String name,Type type){
		StringBuffer buffer =  new StringBuffer("select count(*) from Product p where 1=1");
		Map<String,Object> params= new HashMap<>();
		if(!"".equals(name)&&name!=null){
			buffer.append("  and p.name like :name");
			params.put("name",  "%" +name + "%");
		}
		if(!"".equals(type)&&type!=null){
			buffer.append(" and p.type = :type ");
			params.put("type", type);
		}
		String sql = buffer.toString();
		List<Object> query =(List<Object>) this.query(sql,params);
		Number number = (Number) query.get(0);
		return number.intValue();
	}
	//list product
	public List<Product> selectProduct(Page page,String name,Type type){
		StringBuffer buffer =  new StringBuffer("select p from Product p where 1=1");
		Map<String,Object> params= new HashMap<>();
		if(!"".equals(name)&&name!=null){
			buffer.append(" and p.name like :name ");
			params.put("name", "%" +name + "%");
		}
		if(!"".equals(type)&&type!=null){
			buffer.append(" and p.type = :type ");
			params.put("type", type);
		}
		String sql = buffer.toString();
		List<Product> query = (List<Product>) this.query(sql, page.getBeginIndex(), page.getPageSize(), params);
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
