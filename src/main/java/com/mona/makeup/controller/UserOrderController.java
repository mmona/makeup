package com.mona.makeup.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Orderr;
import com.mona.makeup.utils.StringUtils;

@Controller
public class UserOrderController extends BaseController {
	/*
	 * @RequestMapping(value="/selectUserOrder") public ModelAndView
	 * selectOrder(String id,String curPage,String times,String delivery){
	 * ModelAndView modelAndView = new ModelAndView(); boolean blank =
	 * StringUtils.isBlank(curPage); int cPage = 0; if (blank) { cPage = 1; }
	 * else { cPage = Integer.parseInt(curPage); } Result<Orderr>
	 * selectOrder=null; if("".equals(delivery)&&"".equals(times)){ selectOrder
	 * = userOrderService.selectUserOrder(cPage, null, null,
	 * Integer.parseInt(id)); } if(!"".equals(times)&&null!=times){
	 * selectOrder=userOrderService.selectUserOrder(cPage, times, null,
	 * Integer.parseInt(id)); } if(!"".equals(delivery)&&"".equals(times)){
	 * selectOrder =userOrderService.selectUserOrder(cPage, null,
	 * Integer.parseInt(delivery), Integer.parseInt(id)); }
	 * if(!"".equals(delivery)&&!"".equals(times)&&null!=delivery&&null!=times){
	 * selectOrder=userOrderService.selectUserOrder(cPage, times,
	 * Integer.parseInt(delivery),Integer.parseInt(id)); }
	 * if(selectOrder!=null){ modelAndView.setViewName("qiantai/order.jsp");
	 * modelAndView.addObject("result", selectOrder);
	 * 
	 * } return modelAndView; }
	 */
	@RequestMapping(value="selectuserorder")
	public ModelAndView selectuserorder(String id, String curPage) {
		ModelAndView modelAndView = new ModelAndView();
		boolean blank = StringUtils.isBlank(curPage);
		int cPage = 0;
		if (blank) {
			cPage = 1;
		} else {
			cPage = Integer.parseInt(curPage);
		}
		Result<Orderr> selectUserOrder = userOrderService.selectUserOrder(cPage, null, null, Integer.parseInt(id));
		if (selectUserOrder != null) {
			modelAndView.setViewName("qiantai/order.jsp");
			modelAndView.addObject("result", selectUserOrder);
		}
		return modelAndView;
	}
}
