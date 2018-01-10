package com.mona.makeup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mona.makeup.dao.OrderDao;
import com.mona.makeup.dao.TypeDao;
import com.mona.makeup.page.utils.Page;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Order;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	//select order
	public Result<Order> selectOrder(int curPage,String times,Integer delivery){
		Result<Order> result = new Result<>();
		Page page  = new Page();
		int count = orderDao.countOrder(times, delivery);
		page.setBeginIndex((curPage-1)*10);
		page.setCurrentPage(curPage);
		page.setPageSize(10);
		page.setTotalCount(count);
		page.setTotalPage((count%10==0)?(count/10):(count/10+1));
		List<Order> list = orderDao.selectOrder(page, times, delivery);
		result.setList(list);
		result.setPage(page);
		return result;
	}
}
