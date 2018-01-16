package com.mona.makeup.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.aop.framework.autoproxy.target.QuickTargetSourceCreator;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mona.makeup.page.utils.Page;
import com.mona.makeup.pojo.Orderr;
@Repository
public class OrderDao extends CommonDao{
	//count order
	public Integer countOrder(String times,Integer delivery){
		StringBuffer buffer =  new StringBuffer("Select Count(*) from Orderr o where o.isorder=1");
		Map<String,Object> params= new HashMap<>();
		if(!"".equals(times)&&times!=null){
			buffer.append(" and o.times=:times ");
			params.put("times", times);
		}
		if(null != delivery){
			buffer.append(" and o.delivery=:delivery ");
			params.put("delivery",delivery);
		}
		String sql = buffer.toString();
		List<Object> query = (List<Object>) this.query(sql, params);
		return Integer.parseInt(query.get(0).toString());
	}
	//seelct Order by Page 
	public List<Orderr> selectOrder(Page page,String times,Integer delivery){
		StringBuffer buffer =  new StringBuffer("Select o from Orderr o where o.isorder=1");
		
		Map<String,Object> params= new HashMap<>();
		if(null != times){
			buffer.append(" and o.times=:times ");
			params.put("times", times);
		}
		if(null != delivery){
			buffer.append(" and o.delivery=:delivery");
			params.put("delivery",delivery);
		}
		buffer.append(" order by o.times desc");
		String sql = buffer.toString();
		List<Orderr> query=this.query(sql,Orderr.class,page.getBeginIndex(), page.getPageSize(),params);

		if(query!=null&&!query.isEmpty()){
			return query;
		}
		return null;
	}
	//update delivery
	@Transactional
	public int updateOrder(Orderr orderr){
		String sql="update Orderr o set o.delivery=:delivery where o.id=:id";
		Map<String, Object> params= new HashMap<>();
		params.put("delivery", orderr.getDelivery());
		params.put("id", orderr.getId());
		int count = this.execRawSql(sql, params);
		if(count>0){
			return count;
		}
		return 0;
	}
	//update reach
	@Transactional
	public int updateReach(Orderr orderr){
		String sql="update Orderr o set o.reach=:reach where o.id=:id";
		Map<String, Object> params= new HashMap<>();
		params.put("reach", orderr.getReach());
		params.put("id", orderr.getId());
		int count = this.execRawSql(sql, params);
		if(count>0){
			return count;
		}
		return 0;
	}
	//delete order
	@Transactional
	public boolean deleteOrder(int id){
		return this.delete(id, Orderr.class);
	}
	//select order by times
	public List<Orderr> selectOrderByTimes(String times){
		String sql="Select o from Orderr o where o.times=:times and o.isorder=1";
		Map<String,Object> params = new HashMap<>();
		params.put("times", times);
		List<Orderr> query = this.query(sql, Orderr.class, params);
		if(query!=null){
			return query;
		}
		return null;
	}
	
}
