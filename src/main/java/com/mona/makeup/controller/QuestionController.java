package com.mona.makeup.controller;

import java.awt.Dialog.ModalityType;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Question;
import com.mona.makeup.utils.StringUtils;

@Controller
public class QuestionController extends BaseController {
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
	
}
