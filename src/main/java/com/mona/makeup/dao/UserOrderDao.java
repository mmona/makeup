package com.mona.makeup.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.Order;

import org.apache.poi.ss.formula.functions.Count;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.mona.makeup.page.utils.Page;
import com.mona.makeup.pojo.Orderr;
import com.mona.makeup.pojo.Product;
import com.mona.makeup.pojo.User;

@Repository
public class UserOrderDao extends CommonDao {
	//select user order count 
	public int countUserOrder(User user,String times,Integer delivery,String name){
		StringBuffer buffer =  new StringBuffer("Select Count(*) from Orderr o where o.isorder!= 0 and o.user=:user");
		Map<String,Object> params= new HashMap<>();
		params.put("user", user);
	
		if(!"".equals(times)&&times!=null){
			buffer.append(" and o.times=:times ");
			params.put("times", times);
		}
		if(null != delivery){
			buffer.append(" and o.delivery=:delivery ");
			params.put("delivery",delivery);
		}
		if(null != name){
			buffer.append(" and  o.product=(select p from Product p where p.name like :name) ");
			params.put("name",  "%" +name + "%");
		}
		String sql = buffer.toString();
		List<Object> query = (List<Object>) this.query(sql, params);
		return Integer.parseInt(query.get(0).toString());
	}
	//delete oeder by id 
	@Transactional
	public boolean deleteOrder(int id ){
		return this.delete(id, Orderr.class);
	}
	//select order
	 public List<Orderr> selectUserOrder(Page page,String times,Integer delivery,User user,String name ){
		 StringBuffer buffer =  new StringBuffer("Select o from Orderr o where o.isorder != 0 and o.user=:user");
			Map<String,Object> params= new HashMap<>();
			params.put("user", user);
			if(!"".equals(times)&&times!=null){
				buffer.append(" and o.times=:times ");
				params.put("times", times);
			}
			if(!"".equals(delivery)&&delivery!=null){
				buffer.append(" and o.delivery=:delivery ");
				params.put("delivery",delivery);
			}
			if(!"".equals(name)&&name!=null){
				buffer.append(" and o.product=(select p from Product p where p.name like :name) ");
				params.put("name",  "%" +name + "%");
			}
			buffer.append(" order by o.times desc");
			String sql = buffer.toString();
			List<Orderr> query=this.query(sql,Orderr.class,page.getBeginIndex(), page.getPageSize(),params);

			if(query!=null&&!query.isEmpty()){
				return query;
			}
			return null;
	 }
	 //count shopping
	 public int countshopping(User user){
		 StringBuffer buffer =  new StringBuffer("Select Count(*) from Orderr o where o.isorder=0 and o.user=:user");
			Map<String,Object> params= new HashMap<>();
			params.put("user", user);
			String sql = buffer.toString();
			List<Object> query = (List<Object>) this.query(sql, params);
			return Integer.parseInt(query.get(0).toString());
	 }
	 //select isshoppingcar
	 public List<Orderr> selectShopping(Page page,User user){
		 StringBuffer buffer =  new StringBuffer("Select o from Orderr o where o.isorder=0 and o.user=:user");
		 buffer.append(" order by o.times desc");
			String sql = buffer.toString();
			Map<String,Object> params= new HashMap<>();
			params.put("user", user);
			List<Orderr> query=this.query(sql, Orderr.class, page.getBeginIndex(), page.getPageSize(), params);

			if(query!=null&&!query.isEmpty()){
				return query;
			}
			return null;
	 }
	 //delete Shoppingcar by id
	 @Transactional
	 public boolean deleteShoppingCar(int id){
		 return this.delete(id, Orderr.class);
	 }
	//uodate 	updateShoppingCar  只是修改单个
	 @Transactional
	 public int updateShoppingCar(int id,int productsum){
		 String sql="update Orderr o set o.isorder=1,o.productsum=:productsum where o.id=:id";
		 Map< String ,Object> params = new HashMap<>();
		 params.put("id", id);
		 params.put("productsum", productsum);
		 int execRawSql = this.execRawSql(sql, params);
		 if(execRawSql>0){
			 return execRawSql;
		 }
		 return 0;
	 }
	 //update productsum \
	 @Transactional
	 public boolean updateProductsum(int id,int productsum){
		String sql = "update Orderr o set o.productsum=:productsum where o.id=:id";
		 Map< String ,Object> params = new HashMap<>();
		 params.put("id", id);
		 params.put("productsum", productsum);
		 int execRawSql = this.execRawSql(sql, params);
		 if(execRawSql>0){
			 return true;
		 }
		 return false;
	 }
	 //update shopping 
	 @Transactional
	 public int updateshopping(User user,String times){
		 String sql="update Orderr o set o.isorder=1,o.times=:times where o.user=:user and o.isorder=0"; 
		 Map< String ,Object> params = new HashMap<>();
		 params.put("user", user);
		 params.put("times", times);
		 int execRawSql = this.execRawSql(sql, params);
		 if(execRawSql>0){
			 return execRawSql;
		 }
		 return 0;
	 }
	 //delete shopping by user
	 @Transactional
	 public int deleteShopping(User user){
		 String sql="delete from Orderr o where o.isorder=0 and o.user=:user";
		 Map< String ,Object> params = new HashMap<>();
		 params.put("user", user);
		 int execRawSql = this.execRawSql(sql, params);
		 if(execRawSql>0){
			 return execRawSql;
		 }
		 return 0;
	 }
	/* public boolean deleteShopping(Orderr orderr){
		 return this.delete(orderr);
	 }*/
	 //select shoping 
	 public List<Orderr> indexshopping(User user){
		 StringBuffer buffer =  new StringBuffer("Select o from Orderr o where o.isorder=0 and o.user=:user");
		 buffer.append(" order by o.times desc");
			String sql = buffer.toString();
			Map<String,Object> params= new HashMap<>();
			params.put("user", user);
			List<Orderr> query = this.query(sql, Orderr.class, params);
			if(query!=null&&!query.isEmpty()){
				return query;
			}
			return null;
	 }
	 //select recommend
	 public List<Product> selectRecommend(){
		 String sql = "select p from Product p  where p.recommend = 1 ";
		List<Product> query = (List<Product>) this.query(sql);
		 if(query!=null&&!query.isEmpty()){
				return query;
			}
			return null;
	 }
	 //add shopping
	 @Transactional
	 public boolean addShoppingCar(Orderr orderr ){
		 return this.save(orderr);
	 }
	 //select shopping orderr by product 
	 public Orderr selectShoppingByProduct(Product product,User user ){
		String sql = "Select o from Orderr o where o.product=:product and o.isorder=0 and o.user=:user "; 
		Map<String,Object> params= new HashMap<>();
		params.put("product", product);
		params.put("user", user);
		List<Orderr> query = this.query(sql, Orderr.class, params);
		if(query!=null&&!query.isEmpty()){
			return query.get(0);
		}
		return null;
	 }
}
