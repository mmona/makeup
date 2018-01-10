package com.mona.makeup.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mona.makeup.pojo.Review;
@Repository
public class ReviewDao extends CommonDao{
	//add review
	@Transactional
	public boolean addReview(Review review){
		 boolean save = this.save(review);
		 return save;
	}
}

