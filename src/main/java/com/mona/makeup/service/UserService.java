package com.mona.makeup.service;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mona.makeup.dao.UserDao;
import com.mona.makeup.page.utils.Page;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.User;

@Service
public class UserService extends BaseService {
	@Autowired
	private UserDao userDao;
	public Result<User> selectUser(int curPage){
		Result<User> result = new Result<>();
		Page page  = new Page();
		int count = userDao.selectUserCount();
		page.setBeginIndex((curPage-1)*10);
		page.setCurrentPage(curPage);
		page.setPageSize(10);
		page.setTotalCount(count);
		page.setTotalPage((count%10==0)?(count/10):(count/10+1));
		List<User> selectUser = userDao.selectUser(page);
		result.setList(selectUser);
		result.setPage(page);
		return result;
	}
	//selete User by id
	public  User selectUserById(int id){
		return userDao.selectUserById(id);
	}
	//update user by id
	@Transactional
	public boolean updateUserById(User user){
		int userById = userDao.updateUserById(user);
		if(userById>0){
			return true;
		}
		return false;
	}
	//delete user by id 
	@Transactional
	public boolean deleteUserById(int id){
		boolean delete = commonDao.delete(id, User.class);
		return delete;
	}
	//login user 
	public User login(String username,String password){
		return userDao.login(username, password);
	}
	//select user by name
	public User selectuserByname(String username){
		return userDao.selectUserByUsername(username);
	}

	//add user 
	public boolean addUser(User user){
	/*	User selectUserByUsername = userDao.selectUserByUsername(user.getUsername());
		if(selectUserByUsername==null){*/
			return userDao.addUser(user);
		/*}
		return  false;*/
	}
	//update user
	public boolean updateUser(User user){
		return userDao.updateUser(user);
	}
}

