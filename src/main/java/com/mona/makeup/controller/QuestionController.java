package com.mona.makeup.controller;

import java.awt.Dialog.ModalityType;
import java.awt.event.MouseAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpSession;

import org.apache.xmlbeans.impl.jam.mutable.MMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mona.makeup.dao.QuestionDao;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Question;
import com.mona.makeup.pojo.Review;
import com.mona.makeup.pojo.User;
import com.mona.makeup.utils.StringUtils;

@Controller
public class QuestionController extends BaseController {
	@Autowired 
	private QuestionDao questionDao;
	@RequestMapping(value="selectQuestion")
	public ModelAndView selectQuestion(String curPage,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		boolean blank = StringUtils.isBlank(curPage);
		int cPage=0;
		if( blank){
			cPage=1;
		}else {
			cPage=Integer.parseInt(curPage);
		}
		Result<Question> question = questionService.selectQuestion(cPage);
		if(question !=null){
			int pageSize =  question.getPage().getPageSize();
			session.setAttribute("pageSize", pageSize);
			session.setAttribute("curPage",curPage);
			modelAndView.setViewName("admin/question.jsp");
			modelAndView.addObject("result", question);
		}
		return modelAndView;
	}
	@RequestMapping(value="selectQuestionById")
	public ModelAndView selectQuestionById(String id,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		Question questionById = questionService.selectQuestionById(Integer.parseInt(id));
		if (questionById!=null) {
			modelAndView.addObject("question", questionById);
			session.setAttribute("question",questionById);
			modelAndView.setViewName("admin/question_update.jsp");
		}
		return modelAndView;
	}
	@RequestMapping(value="reviewQuestion")
	public ModelAndView addReview(String content,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		String times=dateFormat.format( now );
		Question question = (Question) session.getAttribute("question");
		User users = question.getUsers();
		Review review = new Review();
		review.setContent(content);
		review.setTime(times);
		review.setQuestion(question);
		review.setUsers(users);
		boolean addReview = reviewService.addReview(review);
		if(addReview){
			String  curPage = (String) session.getAttribute("curPage");
			if(null== curPage ){
				curPage="1";
			}else{
				curPage = curPage;
			}
			modelAndView.setViewName("selectReview.do?curPage="+ curPage+"");
			modelAndView.addObject("success","<script>alert('回复成功!')</script>");
		}
		return modelAndView;
	}
	@RequestMapping(value="deleteQuestion")
	public ModelAndView deleteQuestion(String id,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		boolean deleteQuestion = questionService.deleteQuestion(Integer.parseInt(id));
		
		if(deleteQuestion){
			int count = questionDao.countQuestion();
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
			modelAndView.setViewName("selectQuestion.do?curPage="+ curPage+"");
			modelAndView.addObject("success","<script>alert('删除成功!')</script>");
		}
		return modelAndView;
		
	}
	@RequestMapping(value="qiantai/addQuestion")
	public ModelAndView addQuestion(HttpSession session,String content ){
		ModelAndView modelAndView = new ModelAndView();
		Question question = new Question();
		User user = (User) session.getAttribute("user");
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		String times=dateFormat.format( now );
		question.setContent(content);
		question.setTimes(times);
		question.setUsers(user);
		boolean addQuestion = questionService.addQuestion(question);
		if(addQuestion){
			modelAndView.setViewName("answer.jsp");
			modelAndView.addObject("success","<script>alert('提问成功!')</script>");
		}else {
			modelAndView.setViewName("answer.jsp");
			modelAndView.addObject("fail","<script>alert('提问失败，请重新提问!')</script>");
		}
		return modelAndView;
	}
}
