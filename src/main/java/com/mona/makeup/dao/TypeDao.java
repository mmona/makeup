package com.mona.makeup.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

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
	//add type
	@Transactional 
	public boolean addtype(Type type){
		/*String sql="insert into Type(tname,description,product) values(tname=:tname,description=:description,product=:product)";
		Map<String,Object> params = new HashMap<>();
		params.put("tname", type.getTname());
		params.put("description", type.getDescription());
		params.put("product", type.getProduct());
		int isAdd = this.execRawSql(sql, params);
		if(isAdd>0){
			return isAdd;
		}
		return 0;*/
		boolean save = this.save(type);
		return save;
	}
	//select type by id
	public Type selectTypeById(int id ){
		String sql="select t from Type t where t.id=:id";
		Map<String, Object> params=  new HashMap<>();
		params.put("id", id);
		List<Type> query = this.query(sql, Type.class, params);
		if(query!=null&&!query.isEmpty()){
			return query.get(0);
		}
		return null;
	}
	//update type 
	@Transactional
	public int  updateType(Type type){
		String sql="update Type set tname=:tname,description=:description where id=:id";
		Map<String , Object> params = new HashMap<>();
		params.put("description", type.getDescription());
		params.put("tname", type.getTname());
		params.put("id", type.getId());
		int execRawSql = this.execRawSql(sql, params);
		if(execRawSql>0){
			return execRawSql;
		}
		return 0;
	}
	//delete Type
	@Transactional
	public boolean deleteType(int id){
		boolean delete = this.delete(id, Type.class);
		return delete;
	}
	//select type
	public List<Type> typeInfo(){
		List<Type> query = this.query(Type.class);
		if( query!=null){
			return query;
		}
		return null;
	}

}
