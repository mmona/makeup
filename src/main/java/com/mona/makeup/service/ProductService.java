package com.mona.makeup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mona.makeup.dao.ProductDao;
import com.mona.makeup.page.utils.Page;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Product;
import com.mona.makeup.pojo.Type;

@Service
public class ProductService extends BaseService {
	@Autowired
	private ProductDao productDao;

	// select product
	public Result<Product> selectProduct(int curPage,String name,Type type ) {
		Result<Product> result = new Result<>();
		int count = productDao.countProduct(name);
		Page page = new Page();
		page.setBeginIndex((curPage - 1) * 10);
		page.setCurrentPage(curPage);
		page.setPageSize(10);
		page.setTotalCount(count);
		page.setTotalPage((count % 10 == 0) ? (count / 10) : (count / 10 + 1));
		List<Product> selectProduct = productDao.selectProduct(page,name,type);
		result.setList(selectProduct);
		result.setPage(page);
		return result;
	}

	// select product by id
	public Product selectProductById(int id) {
		return productDao.selectProductById(id);
	}

	// update product
	public boolean updateProduct(Product product) {
		return productDao.updateProduct(product);
	}
	//delete product 
	public boolean deleteProduct(int id){
		return productDao.deleteProduct(id);
	}
	//add product
	public boolean addProduct(Product product) {
		return productDao.addProduct(product);
	}

}
