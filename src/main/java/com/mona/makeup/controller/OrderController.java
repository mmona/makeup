package com.mona.makeup.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.hibernate.engine.spi.SessionEventListenerManager;
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
		Result<Orderr> selectOrder = orderService.selectOrder(cPage,null,null,null);
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
			if(null== curPage ){
				curPage="1";
			}else{
				curPage = curPage;
			}
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
			if(null== curPage ){
				curPage="1";
			}else{
				curPage = curPage;
			}
			modelAndView.setViewName("selectOrder.do?curPage="+curPage+"");
			modelAndView.addObject("update", "<script>alert('订单已取消!')</script>");
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
			if(null== curPage ){
				curPage="1";
			}else{
				curPage = curPage;
			}
			modelAndView.setViewName("selectOrder.do?curPage="+curPage+"");
			modelAndView.addObject("update", "<script>alert('订单已送达!')</script>");
		}
		return modelAndView;
	}
	@RequestMapping(value="deleteOrder")
	public ModelAndView deleteOrder(String id,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		boolean deleteOrder = orderService.deleteOrder(Integer.parseInt(id));
		if(deleteOrder){
			int count  = orderDao.countOrder(null, null,null);
			String curPage = (String) session.getAttribute("curPage");
			int pageSize = (int) session.getAttribute("pageSize");
			if (count%pageSize==0) {
				int a = Integer.parseInt(curPage) - 1;
				curPage = String.valueOf(a);
			} else {
				if(null== curPage ){
					curPage="1";
				}else{
					curPage = curPage;
				}
			}
			
			modelAndView.setViewName("selectOrder.do?curPage="+curPage+"");
			modelAndView.addObject("update", "<script>alert('订单删除成功!')</script>");
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
	@RequestMapping(value="searchOrders")
	public ModelAndView searchOrder(String curPage,String delivery,String times,String name,HttpSession session){
		ModelAndView modelAndView=new ModelAndView();
		boolean blank = StringUtils.isBlank(curPage);
		int cPage = 0;
		if (blank) {
			cPage = 1;
		} else {
			cPage = Integer.parseInt(curPage);
		}
		Result<Orderr> selectOrder=null;
		if(null==times&&null==name&&null==delivery){
			session.removeAttribute("name");
			session.removeAttribute("delivery");
			session.removeAttribute("times");
			selectOrder=orderService.selectOrder(cPage,null,null,null);
		}
		if("".equals(times)&&"".equals(name)&&"".equals(delivery)){
			session.removeAttribute("name");
			session.removeAttribute("delivery");
			session.removeAttribute("times");
			selectOrder=orderService.selectOrder(cPage,null,null,null);
		}
		if(!"".equals(times)&&null!=times&&"".equals(name)&&"".equals(delivery)){
			session.removeAttribute("name");
			session.removeAttribute("delivery");
			session.setAttribute("times", times);
			selectOrder=orderService.selectOrder(cPage,times,null,null);
		}
		if(!"".equals(name)&&null!=name&&"".equals(times)&&"".equals(delivery)){
			session.removeAttribute("times");
			session.removeAttribute("delivery");
			session.setAttribute("name", name);
			selectOrder=orderService.selectOrder(cPage,null,null,name);
		}
		if(!"".equals(delivery)&&null!=delivery&&"".equals(name)&&"".equals(times)){
			session.removeAttribute("name");
			session.removeAttribute("times");
			session.setAttribute("delivery",delivery);
			selectOrder=orderService.selectOrder(cPage,null,Integer.parseInt(delivery),null);
		}
		if(!"".equals(times)&&null!=name&&!"".equals(name )&&null!=times&&"".equals(delivery)){
			session.setAttribute("name", name);
			session.setAttribute("times", times);
			session.removeAttribute("delivery");
			selectOrder=orderService.selectOrder(cPage,times,null,name);
		}
		if(null!=times&&!"".equals(delivery)&&"".equals(name)&&!"".equals(times)){
			session.setAttribute("delivery", delivery);
			session.setAttribute("times", times);
			session.removeAttribute("name");
			selectOrder=orderService.selectOrder(cPage,times,Integer.parseInt(delivery),null);
		}
		if(!"".equals(name)&&!"".equals(delivery)&&null!=name&&null!=delivery&&"".equals(times)){
			session.setAttribute("name", name);
			session.setAttribute("delivery", delivery);
			session.removeAttribute("times");
			selectOrder=orderService.selectOrder(cPage,null,Integer.parseInt(delivery),name);
		}
		if(!"".equals(name)&&!"".equals(times)&&!"".equals(delivery)&&null!=name&&null!=delivery&&null!=times){
			session.setAttribute("name", name);
			session.setAttribute("delivery", delivery);
			session.setAttribute("times", times);
			selectOrder=orderService.selectOrder(cPage,times,Integer.parseInt(delivery),name);
		}
		if(selectOrder!=null){
			modelAndView.setViewName("admin/order_search.jsp");
			modelAndView.addObject("result", selectOrder);
			
		}
		return modelAndView;
	}
	@RequestMapping(value="selectOrderByTimes")
	public ModelAndView selectOrderByTimes(){
		ModelAndView modelAndView = new ModelAndView();
		
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		String times=dateFormat.format( now );
		List<Orderr> orderByTimes = orderService.selectOrderByTimes(times);
		if(orderByTimes!=null){
			modelAndView.setViewName("admin/order_statistic.jsp");
			modelAndView.addObject("order", orderByTimes);
		}
		
		return modelAndView;
	}

	
}
