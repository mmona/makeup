package com.mona.makeup.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mona.makeup.page.utils.Page;
import com.mona.makeup.pojo.Question;
import com.mona.makeup.pojo.Review;
import com.mona.makeup.pojo.User;
@Repository
public class ReviewDao extends CommonDao{
	//add review
	@Transactional
	public boolean addReview(Review review){
		 boolean save = this.save(review);
		 return save;
	}
	//select count review 
	public int selectReviewcount(){
		String sql="select Count(*) from Review";
		List<Object> query = (List<Object>) this.query(sql);
		Number number = (Number) query.get(0);
		return number.intValue();
	}
	//selectReview
	public List<Review> selectReview(Page page ){
		List<Review> query = this.query(Review.class, page.getBeginIndex(), page.getPageSize());
		if(query!=null&&!query.isEmpty()){
			return query;
		}
		return null;
	}
	//delete review 
	@Transactional
	public boolean deleteReview(int id ){
	return  this.delete(id, Review.class);
	}
	//selectReviewByUser
	public List<Review> selectReviewByUser(User user ){
		String sql="select r from Review r where r.users=:users  order by r.time";
		Map<String,Object> params = new HashMap<>();
		params.put("users", user);
		
		List<Review> query = this.query(sql, Review.class, params);
		if(query!=null&&!query.isEmpty()){
			return query;
		}
		return null;
	}
}

