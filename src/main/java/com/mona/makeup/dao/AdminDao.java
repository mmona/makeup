package com.mona.makeup.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

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
}
