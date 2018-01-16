package com.mona.makeup.service;

import java.util.List;

import org.eclipse.jdt.internal.compiler.parser.RecoveredUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mchange.v2.ser.IndirectlySerialized;
import com.mona.makeup.dao.UserOrderDao;
import com.mona.makeup.page.utils.Page;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Orderr;
import com.mona.makeup.pojo.User;

@Service
public class UserOrderService extends BaseService {
	@Autowired 
	private UserOrderDao userOrderDao;
	//select user order
	public Result<Orderr> selectUserOrder(int curPage,String times,Integer delivery,User user){
		Result<Orderr> result = new Result<>();
		Page page  = new Page();
		int count =userOrderDao.countUserOrder(user, times, delivery);
		page.setBeginIndex((curPage-1)*10);
		page.setCurrentPage(curPage);
		page.setPageSize(10);
		page.setTotalCount(count);
		page.setTotalPage((count%10==0)?(count/10):(count/10+1));
		List<Orderr> list = userOrderDao.selectUserOrder(page, times, delivery, user);
		result.setList(list);
		result.setPage(page);
		return result;
	}
	public Result<Orderr> selectShopping(int curPage,User user){
		Result<Orderr> result = new Result<>();
		Page page  = new Page();
		int count =userOrderDao.countshopping(user);
		page.setBeginIndex((curPage-1)*10);
		page.setCurrentPage(curPage);
		page.setPageSize(10);
		page.setTotalCount(count);
		page.setTotalPage((count%10==0)?(count/10):(count/10+1));
		List<Orderr> list = userOrderDao.selectShopping(page, user);
		result.setList(list);
		result.setPage(page);
		return result;
	}
	//delete shopping car 
	public boolean deleteShoppingCar(int id ){
		return userOrderDao.deleteShoppingCar(id);
	}
	//update shopping 
	public boolean updateShopping(User user){
		int updateshopping = userOrderDao.updateshopping(user);
		if(updateshopping>0){
			return true;
		}
		return false;
	}
	//delete shopping by user
	public boolean deteleShopping(User user){
		int deleteShopping = userOrderDao.deleteShopping(user);
		if(deleteShopping >0){
			return true;
		}
		return false;
		/*Orderr orderr = new Orderr();
		orderr.setUser(user);
		return userOrderDao.deleteShopping(orderr);*/
	}
	//select index shopping 
	 public List<Orderr> indexshopping(User user){
		 return userOrderDao.indexshopping(user);
	 }
}
