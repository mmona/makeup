package com.mona.makeup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mona.makeup.page.utils.Page;
import com.mona.makeup.pojo.Type;

@Repository
public class TypeDao extends CommonDao {
	//count type
	public int countType(){
		String sql="select count(*) from Type";
		List<Object> query = (List<Object>) this.query(sql);
		Number number = (Number) query.get(0);
		return number.intValue();
	}
	//select type by page 
	@Transactional
	public List<Type> selectType(Page page){
		List<Type> query = this.query(Type.class, page.getBeginIndex(), page.getPageSize());
		if(query!=null&&!query.isEmpty()){
			return query;
		}
		return null;
		
	}

	

}
