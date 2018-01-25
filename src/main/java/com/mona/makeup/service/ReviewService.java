package com.mona.makeup.service;

import java.util.List;

import org.hibernate.engine.jdbc.spi.ResultSetReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mona.makeup.dao.ReviewDao;
import com.mona.makeup.page.utils.Page;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Question;
import com.mona.makeup.pojo.Review;
import com.mona.makeup.pojo.User;

@Service
public class ReviewService extends BaseService {
	@Autowired
	private ReviewDao reviewDao;
	// addReview
	@Transactional
	public boolean addReview(Review review){
		
		return reviewDao.addReview(review);
	}
	//selectrReview
	public Result<Review> selectReview(int curPage){
		Result<Review> result  = new Result<>();
		Page page  = new Page();
		int count  = reviewDao.selectReviewcount();
		page.setBeginIndex((curPage-1)*10);
		page.setCurrentPage(curPage);
		page.setPageSize(10);
		page.setTotalCount(count);
		page.setTotalPage((count%10==0)?(count/10):(count/10+1));
		List<Review> selectReview = reviewDao.selectReview(page);
		result.setList(selectReview);
		result.setPage(page);
		return result;
	}
	//delete review 
	public boolean deleteReview(int id){
		return reviewDao.deleteReview(id);
	}
	//select review by user
	public Result<Review> selectReviewByUser(User user,int curPage ){
		Result<Review> result = new Result<>();
		int count  = reviewDao.selectReviewByUserCount(user);
		Page page  = new Page();
		page.setBeginIndex((curPage-1)*5);
		page.setCurrentPage(curPage);
		page.setPageSize(5);
		page.setTotalCount(count);
		page.setTotalPage((count%5==0)?(count/5):(count/5+1));
		List<Review> selectReviewByUser = reviewDao.selectReviewByUser(user, page);
		result.setList(selectReviewByUser);
		result.setPage(page);
		return result;
	}
}


