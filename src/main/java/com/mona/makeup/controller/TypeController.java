package com.mona.makeup.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.sql.Select;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Type;

@Controller
public class TypeController extends BaseController{
	@RequestMapping(value="selectType")
	@Transactional
	public ModelAndView selectType(String curPage,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		int cPage = (curPage!=null)?Integer.parseInt(curPage):1;
		Result<Type> selectType = typeService.selectType(cPage);
		if(selectType!=null){
			int pageSize = selectType.getPage().getPageSize();
			int beginIndex = selectType.getPage().getBeginIndex();
			int totalPage = selectType.getPage().getTotalPage();
			session.setAttribute("pageSize", pageSize);
			session.setAttribute("beginIndex", beginIndex);
			session.setAttribute("totalPage", totalPage);
			session.setAttribute("curPage",curPage);
			modelAndView.addObject("result", selectType);
			modelAndView.setViewName("admin/type.jsp");
		}
		
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="addType")
	public ModelAndView addType(String tname,String description){
		ModelAndView modelAndView= new ModelAndView();
		Type type = new Type();
		type.setDescription(description);
		type.setTname(tname);
		boolean addType = typeService.addType(type);
		if(addType){
			modelAndView.setViewName("admin/type.jsp");
		}
		return modelAndView;
		
		
	}
}
