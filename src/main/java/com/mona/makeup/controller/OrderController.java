package com.mona.makeup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Order;
import com.mona.makeup.utils.StringUtils;

@Controller
public class OrderController extends BaseController {
	@RequestMapping("selectOrder")
	public ModelAndView selectOrder(String curPage,HttpSession session){
		ModelAndView modelAndView=new ModelAndView();
		boolean blank = StringUtils.isBlank(curPage);
		int cPage = 0;
		if (blank) {
			cPage = 1;
		} else {
			cPage = Integer.parseInt(curPage);
		}
		Result<Order> selectOrder = orderService.selectOrder(cPage, null, null);
		if(selectOrder!=null){
			int pageSize = selectOrder.getPage().getPageSize();
			int beginIndex = selectOrder.getPage().getBeginIndex();
			int totalPage = selectOrder.getPage().getTotalPage();
			session.setAttribute("pageSize", pageSize);
			session.setAttribute("curPage", curPage);
			modelAndView.setViewName("admin/order.jsp");
			modelAndView.addObject("result", selectOrder);
			
		}
		return modelAndView;
	}
}
