package com.mona.makeup.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mona.makeup.dao.OrderDao;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Orderr;
import com.mona.makeup.utils.StringUtils;

@Controller
public class OrderController extends BaseController {
	@Autowired
	private OrderDao orderDao;
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
		Result<Orderr> selectOrder = orderService.selectOrder(cPage,null,null);
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
	@RequestMapping(value="updateOrder")
	public ModelAndView updateOrder(String id,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		Orderr orderr = new Orderr();
		orderr.setId(Integer.parseInt(id));
		orderr.setDelivery(1);
		boolean updateOrder = orderService.updateOrder(orderr);
		if(updateOrder){
			String  curPage = (String) session.getAttribute("curPage");
			modelAndView.setViewName("selectOrder.do?curPage="+curPage+"");
		}
		return modelAndView;
	}
	@RequestMapping(value="updatedelivery")
	public ModelAndView updatedelivery(String id,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		Orderr orderr = new Orderr();
		orderr.setId(Integer.parseInt(id));
		orderr.setDelivery(0);
		boolean updateOrder = orderService.updateOrder(orderr);
		if(updateOrder){
			String  curPage = (String) session.getAttribute("curPage");
			modelAndView.setViewName("selectOrder.do?curPage="+curPage+"");
		}
		return modelAndView;
	}
	@RequestMapping(value="updateReach")
	public ModelAndView updateReach(String id,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		Orderr orderr = new Orderr();
		orderr.setId(Integer.parseInt(id));
		orderr.setReach(1);
		boolean updateOrder = orderService.updateReach(orderr);
		if(updateOrder){
			String  curPage = (String) session.getAttribute("curPage");
			modelAndView.setViewName("selectOrder.do?curPage="+curPage+"");
		}
		return modelAndView;
	}
	@RequestMapping(value="deleteOrder")
	public ModelAndView deleteOrder(String id,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		boolean deleteOrder = orderService.deleteOrder(Integer.parseInt(id));
		if(deleteOrder){
			int count  = orderDao.countOrder(null, null);
			String curPage = (String) session.getAttribute("curPage");
			int pageSize = (int) session.getAttribute("pageSize");
			if (count%pageSize==0) {
				int a = Integer.parseInt(curPage) - 1;
				curPage = String.valueOf(a);
			} else {
				curPage = curPage;
			}
			
			modelAndView.setViewName("selectOrder.do?curPage="+curPage+"");
		}
		return modelAndView;
	}
	/*@RequestMapping(value="selectOrderSearch")
	public ModelAndView selectOrderSearch(String curPage,HttpSession session){
		ModelAndView modelAndView=new ModelAndView();
		boolean blank = StringUtils.isBlank(curPage);
		int cPage = 0;
		if (blank) {
			cPage = 1;
		} else {
			cPage = Integer.parseInt(curPage);
		}
		Result<Orderr> selectOrder = orderService.selectOrder(cPage,null,null);
		if(selectOrder!=null){
			int pageSize = selectOrder.getPage().getPageSize();
			int beginIndex = selectOrder.getPage().getBeginIndex();
			int totalPage = selectOrder.getPage().getTotalPage();
			session.setAttribute("pageSize", pageSize);
			session.setAttribute("curPage", curPage);
			modelAndView.setViewName("admin/order_search.jsp");
			modelAndView.addObject("result", selectOrder);
			
		}
		return modelAndView;
	}*/
	@RequestMapping(value="searchOrder")
	public ModelAndView searchOrder(String curPage,String delivery,String times){
		ModelAndView modelAndView=new ModelAndView();
		boolean blank = StringUtils.isBlank(curPage);
		int cPage = 0;
		if (blank) {
			cPage = 1;
		} else {
			cPage = Integer.parseInt(curPage);
		}
		Result<Orderr> selectOrder=null;
		if(!"".equals(times)&&null!=times){
			selectOrder=orderService.selectOrder(cPage,times,null);
		}
		if("".equals(delivery)&&"".equals(times)){
			selectOrder = orderService.selectOrder(cPage,null,null);
		}
		if(delivery==null&&delivery==null){
			selectOrder = orderService.selectOrder(cPage,null,null);
		}
		if(!"".equals(delivery)&&"".equals(times)){
			selectOrder = orderService.selectOrder(cPage,null,Integer.valueOf(delivery));
		}
		 if(!"".equals(delivery)&&!"".equals(times)&&null!=delivery&&null!=times){
			 selectOrder=orderService.selectOrder(cPage,times,Integer.valueOf(delivery));
		 }
		if(selectOrder!=null){
			modelAndView.setViewName("admin/order_search.jsp");
			modelAndView.addObject("result", selectOrder);
			
		}
		return modelAndView;
	}
	
}
