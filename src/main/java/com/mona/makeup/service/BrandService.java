package com.mona.makeup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mona.makeup.dao.BrandDao;
import com.mona.makeup.page.utils.Page;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Brand;
import com.mysql.jdbc.BlobFromLocator;

@Service
public class BrandService extends BaseService {
	@Autowired
	private BrandDao brandDao;

	// select brand page
	public Result<Brand> selectBrand(int curPage) {
		Result<Brand> result = new Result<>();
		Page page  = new Page();
		int count = brandDao.countBrand();
		page.setBeginIndex((curPage-1)*10);
		page.setCurrentPage(curPage);
		page.setPageSize(10);
		page.setTotalCount(count);
		page.setTotalPage((count%10==0)?(count/10):(count/10+1));
		List<Brand> selectBrand = brandDao.selectBrand(page);
		result.setList(selectBrand);
		result.setPage(page);
		return result;
	}
	// select brand by id
	
	public Brand selectBranfById(int id){
		return brandDao.selectBrandById(id);
	}
	//update brand 
	public boolean updateBrand(Brand brand){
		int updateBrand = brandDao.updateBrand(brand);
		if(updateBrand>0){
			return true;
		}
		return false;
	}
	//delete brand
	@Transactional
	public boolean deleteBrand(int id ){
		return brandDao.deleteBrand(id);
	}
	//add brand  
	 @Transactional
	 public boolean addBrand(Brand brand){
		 return brandDao.addBrand(brand);
	 }
}
