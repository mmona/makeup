package com.mona.makeup.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mona.makeup.dao.ReviewDao;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Question;
import com.mona.makeup.pojo.Review;
import com.mona.makeup.pojo.User;
import com.mona.makeup.utils.StringUtils;

@Controller
public class ReviewController extends BaseController{
	@Autowired
	private ReviewDao reviewDao;
	@RequestMapping(value="selectReview")
	public ModelAndView selectReview(String curPage,HttpSession session){
		ModelAndView modelAndView = new  ModelAndView();
		boolean blank = StringUtils.isBlank(curPage);
		int cPage=0;
		if( blank){
			cPage=1;
		}else {
			cPage=Integer.parseInt(curPage);
		}
		Result<Review> selectReview = reviewService.selectReview(cPage);
		if(selectReview!=null){
			int pageSize =  selectReview.getPage().getPageSize();
			session.setAttribute("pageSize", pageSize);
			session.setAttribute("curPage",curPage);
			modelAndView.addObject("result", selectReview);
			modelAndView.setViewName("admin/review.jsp");
		}
		return modelAndView;
	}
	@RequestMapping(value="deleteReview")
	public ModelAndView deleteReview(String id,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		boolean deleteReview = reviewService.deleteReview(Integer.parseInt(id));
		if(deleteReview){
			int count  = reviewDao.selectReviewcount();
			String  curPage  = (String)session.getAttribute("curPage");
			int  pageSize = (int) session.getAttribute("pageSize");
			if(count%pageSize==0){
				int a = Integer.parseInt(curPage)-1;
				curPage = String.valueOf(a);
			}else {
				if(null== curPage ){
					curPage="1";
				}else{
					curPage = curPage;
				}
			}
			modelAndView.setViewName("selectReview.do?curPage="+ curPage+"");
			modelAndView.addObject("success","<script>alert('删除成功!')</script>");
		}
		return modelAndView;
	}
	@RequestMapping(value="qiantai/selectReviewByUser")
	public ModelAndView selectReviewByUser(HttpSession session){
	ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("user");
		List<Review> selectReviewByUser = reviewService.selectReviewByUser(user);
		List<Question> selectQuestionByUser = questionService.selectQuestionByUser(user);
		if(selectReviewByUser!=null){
			
			
			modelAndView.setViewName("answer.jsp");
			modelAndView.addObject("selectReviewByUser",selectReviewByUser);
		
		}
		return modelAndView;
	}
}
