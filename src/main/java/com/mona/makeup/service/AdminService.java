package com.mona.makeup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mona.makeup.dao.AdminDao;

import com.mona.makeup.pojo.Admin;
import com.mona.makeup.pojo.User;
import com.mona.makeup.utils.MD5Util;

@Service
public class AdminService extends BaseService{
	@Autowired
	private AdminDao adminDao;
	public Admin login(Admin admin){
		String password=admin.getPassword();
		password = MD5Util.md5Hex(password);
		Admin login = adminDao.login(admin);
		return login;
	}
	public Admin selectAdminById(int id){
		return adminDao.selectAdminById(id);
	}
@Transactional
	public boolean updateAdmin(Admin admin){
		boolean flag = true;
		Admin admin1 = adminDao.selectAdminById(admin.getId());
		if(admin1!=null){
			flag = adminDao.updateAdmin(admin);
		}
		return flag;
	}
}
