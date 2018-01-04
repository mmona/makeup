package com.mona.makeup.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mona.makeup.pojo.User;

@Repository
public class UserDao extends CommonDao{
	/**
	 * 后台登陆
	 */
	public User login(User user){
		String sql="from User where username=:username and password=:password";
		Map<String,Object> params=new HashMap<>();
		params.put("password", user.getPassword());
		params.put("username", user.getUsername());
		List<User> query = this.query(sql, User.class, params);
		if(query!=null&&!query.isEmpty()){
			return query.get(0);
		}
		return null;
	}
}
