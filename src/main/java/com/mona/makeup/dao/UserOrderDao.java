package com.mona.makeup.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mona.makeup.page.utils.Page;
import com.mona.makeup.pojo.Orderr;

@Repository
public class UserOrderDao extends CommonDao {
	//select user order count 
	public int countUserOrder(int userid,String times,Integer delivery){
		StringBuffer buffer =  new StringBuffer("Select Count(*) from Orderr o where o.userid=:userid");
		Map<String,Object> params= new HashMap<>();
		params.put("userid", userid);
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
	//select order
	 public List<Orderr> selectUserOrder(Page page,String times,Integer delivery,int userid){
		 StringBuffer buffer =  new StringBuffer("Select o from Orderr o where o.userid=:userid");
			Map<String,Object> params= new HashMap<>();
			params.put("userid", userid);
			if(!"".equals(times)&&times!=null){
				buffer.append(" and o.times=:times ");
				params.put("times", times);
			}
			if(null != delivery){
				buffer.append(" and o.delivery=:delivery ");
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
}
