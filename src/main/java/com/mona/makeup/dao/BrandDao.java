package com.mona.makeup.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mona.makeup.page.utils.Page;
import com.mona.makeup.pojo.Brand;

@Repository
public class BrandDao  extends CommonDao{
	//select count brand
	public int countBrand(){
		String sql="select count(*) from Brand";
		List<Object> query = (List<Object>) this.query(sql);
		Number number = (Number) query.get(0);
		return number.intValue();
	}
	//select brand page
	public List<Brand> selectBrand(Page page ){
		List<Brand> query = this.query(Brand.class, page.getBeginIndex(), page.getPageSize());
		if(query!=null&&!query.isEmpty()){
			return query;
		}
		return null;
	}
	//select Brand by id
	public Brand selectBrandById(int id){
		String sql = "select b from Brand b where b.id=:id";
		Map<String , Object> params = new HashMap<>();
		params.put("id", id);
		List<Brand> query = this.query(sql,Brand.class, params);
		if(query!=null&&!query.isEmpty()){
			return query.get(0);
		}
		return null;
	}
	//update brand 
	@Transactional
	public int updateBrand(Brand brand){
		String sql="update Brand set bname=:bname,description=:description where id=:id";
		Map<String , Object> params = new HashMap<>();
		params.put("bname", brand.getBname());
		params.put("description", brand.getDescription());
		params.put("id", brand.getId());
		int update = this.execRawSql(sql, params);
		if(update>0){
			return update;
		}
		return 0;
	}
	//delete brand 
	@Transactional
	public boolean deleteBrand(int  id){
		return this.delete(id, Brand.class);
	}
	//add brand 
	@Transactional
	public boolean addBrand(Brand brand ){
		return  this.save(brand);
	}
	//select brandInfo
	public List<Brand> brandInfo(){
		List<Brand> query = this.query(Brand.class);
		if(query!=null){
			return query;
		}
		return null;
	}
}
