package com.mona.makeup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mchange.v2.ser.IndirectlySerialized;
import com.mona.makeup.dao.UserOrderDao;
import com.mona.makeup.page.utils.Page;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Orderr;

@Service
public class UserOrderService extends BaseService {
	@Autowired 
	private UserOrderDao userOrderDao;
	//select user order
	public Result<Orderr> selectUserOrder(int curPage,String times,Integer delivery,int userid){
		Result<Orderr> result = new Result<>();
		Page page  = new Page();
		int count =userOrderDao.countUserOrder(userid, times, delivery);
		page.setBeginIndex((curPage-1)*10);
		page.setCurrentPage(curPage);
		page.setPageSize(10);
		page.setTotalCount(count);
		page.setTotalPage((count%10==0)?(count/10):(count/10+1));
		List<Orderr> list = userOrderDao.selectUserOrder(page, times, delivery, userid);
		result.setList(list);
		result.setPage(page);
		return result;
	}
}
