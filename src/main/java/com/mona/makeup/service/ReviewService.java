package com.mona.makeup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mona.makeup.dao.ReviewDao;
import com.mona.makeup.pojo.Review;

@Service
public class ReviewService extends BaseService {
	@Autowired
	private ReviewDao reviewDao;
	// addReview
	@Transactional
	public boolean addReview(Review review){
		
		return reviewDao.addReview(review);
	}
}


