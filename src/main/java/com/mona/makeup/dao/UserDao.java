package com.mona.makeup.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mona.makeup.page.utils.Page;
import com.mona.makeup.pojo.User;

@Repository
public class UserDao extends CommonDao {
	//得到usercout
	public int selectUserCount(){
		String sql="select count(*) from User";
		List<Object> query = (List<Object>) this.query(sql);
		Number number = (Number) query.get(0);
		return number.intValue();
	}
	//page user
	public List<User> selectUser(Page page){
		List<User> query = this.query(User.class, page.getBeginIndex(), page.getPageSize());
		if(query!=null&&!query.isEmpty()){
			return query;
		}
		return null;
	}
	//select User by id
	public User selectUserById(int id){
		String sql="select u from User u where u.id=:id";
		Map<String,Object> params=new HashMap<>();
		params.put("id", id);
		List<User> list = this.query(sql, User.class, params);
		if(list!=null&&!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	//update User
	@Transactional
	public int updateUserById(User user){
		String  sql="update User set username=:username,password=:password,realname=:realname,age=:age,card=:card,address=:address,card=:card,"
				+ "telephone=:telephone,code=:code,email=:email where id=:id";
		Map<String ,Object> params = new HashMap<>();
		params.put("username", user.getUsername());
		params.put("password", user.getPassword());
		params.put("realname", user.getRealname());
		params.put("age",user.getAge());
		params.put("address", user.getAddress());
		params.put("card", user.getCard());
		params.put("telephone", user.getTelephone());
		params.put("code", user.getCode());
		params.put("email", user.getEmail());
		params.put("id", user.getId());
		int execRawSql = this.execRawSql(sql, params);
		if(execRawSql>0){
			return execRawSql;
			
		}
		return 0;
	}
	//delete user by id
	@Transactional
	public boolean deleteUserById(int id){
		boolean delete = this.delete(id, User.class);
		return delete;
	}
}
