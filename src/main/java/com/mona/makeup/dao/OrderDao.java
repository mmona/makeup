package com.mona.makeup.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mona.makeup.page.utils.Page;
import com.mona.makeup.pojo.Order;
@Repository
public class OrderDao extends CommonDao{
	//count order
	public Integer countOrder(String times,Integer delivery){
		StringBuffer buffer =  new StringBuffer("Select Count(*) from Order o  where 1=1");
		Map<String,Object> params= new HashMap<>();
		if(!"".equals(times)&&times!=null){
			buffer.append(" and o.times=:times ");
			params.put("times", times);
		}else  if(null != delivery){
			buffer.append(" and o.delivery=:delivery ");
			params.put("delivery",delivery);
		}
		String sql = buffer.toString();
		List<Object> query = (List<Object>) this.query(sql, params);
		return Integer.parseInt(query.get(0).toString());
	}
	//seelct Order by Page 
	public List<Order> selectOrder(Page page,String times,Integer delivery){
		StringBuffer buffer =  new StringBuffer("Select o from Order o where 1=1");
		
		Map<String,Object> params= new HashMap<>();
		if(!"".equals(times)&&times!=null){
			buffer.append(" and o.times=:times ");
			params.put("times", times);
		}else  if(null != delivery){
			buffer.append(" and o.delivery=:delivery ");
			params.put("delivery",delivery);
		}
		String sql = buffer.toString();
		List<Order> query=this.query(sql, Order.class,page.getBeginIndex(), page.getPageSize(),params);

		if(query!=null&&!query.isEmpty()){
			return query;
		}
		return null;
	}
}
