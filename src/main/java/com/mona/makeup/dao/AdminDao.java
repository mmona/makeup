package com.mona.makeup.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mona.makeup.pojo.Admin;
import com.mona.makeup.pojo.User;

@Repository
public class AdminDao extends CommonDao{
	/**
	 * 后台登陆
	 */
	public Admin login(Admin admin){
		String sql=" select a from Admin a where name=:name and password=:password";
		Map<String,Object> params=new HashMap<>();
		params.put("password", admin.getPassword());
		params.put("name", admin.getName());
		List<Admin> query = this.query(sql, Admin.class, params);
		if(query!=null&&!query.isEmpty()){
			return query.get(0);
		}
		return null;
	}
	public Admin selectAdminById(int id ){
		/*String sql="select a from Admin where id=:id";
		Map<String,Object> params=new HashMap<>();
		params.put("id", id);
		this.query(clazz)*/
		Admin admin = this.get(Admin.class, id);
		return admin;
	}
@Transactional
	public boolean updateAdmin(Admin admin){
		String sql="update Admin set name=:name,password=:password where id=:id"; 
		Map<String,Object> params=new HashMap<>();
		params.put("name", admin.getName());
		params.put("password", admin.getPassword());
		params.put("id", admin.getId());
		int isUpdate = this.execRawSql(sql, params);
		if(isUpdate>0){
			return true;
		}
		return false;
	}
}
