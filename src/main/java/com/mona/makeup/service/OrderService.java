package com.mona.makeup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mona.makeup.dao.OrderDao;
import com.mona.makeup.page.utils.Page;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Orderr;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	//select order
	public Result<Orderr> selectOrder(int curPage,String times,Integer delivery){
		Result<Orderr> result = new Result<>();
		Page page  = new Page();
		int count = orderDao.countOrder(times, delivery);
		page.setBeginIndex((curPage-1)*10);
		page.setCurrentPage(curPage);
		page.setPageSize(10);
		page.setTotalCount(count);
		page.setTotalPage((count%10==0)?(count/10):(count/10+1));
		List<Orderr> list = orderDao.selectOrder(page, times, delivery);
		result.setList(list);
		result.setPage(page);
		return result;
	}
	//update delivery
	public boolean updateOrder(Orderr orderr){
		int updateOrder = orderDao.updateOrder(orderr);
		if(updateOrder>0){
			return true;
		}
		return false;
	}
	//update reach
	@Transactional
		public boolean updateReach(Orderr orderr){
			int updateOrder = orderDao.updateReach(orderr);
			if(updateOrder>0){
				return true;
			}
			return false;
		}
	//delete order
		@Transactional
		public boolean deleteOrder(int id ){
			return orderDao.deleteOrder(id);
		}
		//select order by times
		public List<Orderr> selectOrderByTimes(String times){
			return orderDao.selectOrderByTimes(times);
		}
}
