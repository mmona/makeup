package com.mona.makeup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mona.makeup.dao.TypeDao;
import com.mona.makeup.page.utils.Page;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Type;
import com.mona.makeup.pojo.User;



@Service
public class TypeService extends BaseService{
	@Autowired
	TypeDao typeDao = new TypeDao();
	//select type by page 
	@Transactional
	public Result<Type> selectType(int curPage){
		Result<Type> result = new Result<>();
		Page page  = new Page();
		int count = typeDao.countType();
		page.setBeginIndex((curPage-1)*10);
		page.setCurrentPage(curPage);
		page.setPageSize(10);
		page.setTotalCount(count);
		page.setTotalPage((count%10==0)?(count/10):(count/10+1));
		List<Type> typelist = typeDao.selectType(page);
		result.setList(typelist);
		result.setPage(page);
		return result;
	}
 	
	
	@Transactional
	public boolean addType(Type type){
		/*int addtype = typeDao.addtype(type);
		if(addtype>0){
			return true;
		}
		return false;*/
		return typeDao.addtype(type);
	}
	//select type by id
	public Type selectTypeById(int id ){
		return typeDao.selectTypeById(id);
	}
	//update type 
	@Transactional
	public boolean updateType(Type type){
		int isUpdate = typeDao.updateType(type);
		if(isUpdate>0){
			return true;
		}
		return false;
	}
	@Transactional
	public boolean deleteType(int id){
		return typeDao.deleteType(id);
	}
}
