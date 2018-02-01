package com.mona.makeup.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mona.makeup.dao.UserOrderDao;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Orderr;
import com.mona.makeup.pojo.User;
import com.mona.makeup.utils.StringUtils;

@Controller
@RequestMapping(value = "/qiantai")
public class UserOrderController extends BaseController {
	@Autowired
	private UserOrderDao userOrderDao;

	/*
	 * @RequestMapping(value = "qiantai/selectuserorder") public ModelAndView
	 * selectOrder(String id, String curPage, String times, String delivery) {
	 * ModelAndView modelAndView = new ModelAndView(); boolean blank =
	 * StringUtils.isBlank(curPage); int cPage = 0; if (blank) { cPage = 1; }
	 * else { cPage = Integer.parseInt(curPage); } Result<Orderr> selectOrder =
	 * null; if ("".equals(delivery) && "".equals(times)) { selectOrder =
	 * userOrderService.selectUserOrder(cPage, null, null,
	 * Integer.parseInt(id)); } if (!"".equals(times) && null != times) {
	 * selectOrder = userOrderService.selectUserOrder(cPage, times, null,
	 * Integer.parseInt(id)); } if (!"".equals(delivery) && "".equals(times)) {
	 * selectOrder = userOrderService.selectUserOrder(cPage, null,
	 * Integer.parseInt(delivery), Integer.parseInt(id)); } if
	 * (!"".equals(delivery) && !"".equals(times) && null != delivery && null !=
	 * times) { selectOrder = userOrderService.selectUserOrder(cPage, times,
	 * Integer.parseInt(delivery), Integer.parseInt(id)); } if (selectOrder !=
	 * null) { modelAndView.setViewName("qiantai/order.jsp");
	 * modelAndView.addObject("result", selectOrder);
	 * 
	 * } return modelAndView; }
	 */
	@RequestMapping(value = "/selectuserorder")
	public ModelAndView selectuserorder(HttpSession session, String curPage, String times,
			String delivery, /* String name, */
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		// 请求内容转码
		request.setCharacterEncoding("UTF-8");
		// 回传告诉浏览器展示编码
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		boolean blank = StringUtils.isBlank(curPage);
		int cPage = 0;
		if (blank) {
			cPage = 1;
		} else {
			cPage = Integer.parseInt(curPage);
		}
		/*
		 * String method = request.getMethod();
		 * if("Get".equalsIgnoreCase(method)){ curPage = (String)
		 * session.getAttribute("curPage"); times = (String)
		 * session.getAttribute("times"); delivery = (String)
		 * session.getAttribute("delivery"); }else {
		 * session.setAttribute("curPage", curPage);
		 * session.setAttribute("times", times);
		 * session.setAttribute("delivery", delivery); }
		 */
		User user = (User) session.getAttribute("user");
		Result<Orderr> selectUserOrder = null;
		if (null == times && null == delivery && null == name) {
			session.removeAttribute("times");
			session.removeAttribute("name");
			selectUserOrder = userOrderService.selectUserOrder(cPage, null, null, user, null);
		}
		if (times != null && null == delivery && "".equals(name)) {
			session.setAttribute("times", times);
			selectUserOrder = userOrderService.selectUserOrder(cPage, times, null, user, null);

		}
		if (null == times && null != delivery && null == name) {
			session.removeAttribute("times");
			session.removeAttribute("name");
			selectUserOrder = userOrderService.selectUserOrder(cPage, null, Integer.parseInt(delivery), user, null);
		}

		if (null == times && null != name) {
			session.removeAttribute("times");
			session.setAttribute("name", name);
			selectUserOrder = userOrderService.selectUserOrder(cPage, null, null, user, name);
		}
		if (delivery != null && times != null) {
			session.setAttribute("times", times);
			session.removeAttribute("name");
			selectUserOrder = userOrderService.selectUserOrder(cPage, times, Integer.parseInt(delivery), user, null);
		}
		if (!"".equals(name) && times != null && null != name) {
			session.setAttribute("times", times);
			session.setAttribute("name", name);
			selectUserOrder = userOrderService.selectUserOrder(cPage, times, null, user, name);
		}
		if (selectUserOrder != null) {
		
			session.setAttribute("curPage", curPage);
			modelAndView.setViewName("order.jsp");
			modelAndView.addObject("result", selectUserOrder);
		}
		return modelAndView;
	}

	@RequestMapping(value = "deleteOrder")
	public ModelAndView deleteOrder(String id, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		boolean deleteOrder = userOrderService.deleteOrder(Integer.parseInt(id));
		if (deleteOrder) {
			User user = (User) session.getAttribute("user");
			int count = userOrderDao.countUserOrder(user, null, null, null);
			String curPage = (String) session.getAttribute("curPage");
			int pageSize = (int) session.getAttribute("pageSize");
			if (count % pageSize == 0) {
				int a = Integer.parseInt(curPage) - 1;
				curPage = String.valueOf(a);
			} else {
				if (null == curPage) {
					curPage = "1";
				} else {
					curPage = curPage;
				}
			}
			modelAndView.setViewName("selectuserorder.do?curPage=" + curPage + "");
			modelAndView.addObject("update", "<script>alert('订单删除成功!')</script>");
		}
		return modelAndView;
	}

	@RequestMapping(value = "selectShopping")
	public ModelAndView selectShopping(HttpSession session, String curPage) {
		ModelAndView modelAndView = new ModelAndView();
		boolean blank = StringUtils.isBlank(curPage);
		int cPage = 0;
		if (blank) {
			cPage = 1;
		} else {
			cPage = Integer.parseInt(curPage);
		}
		User user = (User) session.getAttribute("user");
		Result<Orderr> selectUserOrder = userOrderService.selectShopping(cPage, user);
		if (selectUserOrder != null) {
			int pageSize = selectUserOrder.getPage().getPageSize();
			session.setAttribute("pageSize", pageSize);
			session.setAttribute("curPage", curPage);
			modelAndView.setViewName("shoppingcar.jsp");
			modelAndView.addObject("result", selectUserOrder);
			session.setAttribute("shoppingcar", selectUserOrder);
		}
		return modelAndView;
	}

	@RequestMapping(value = "deleteShoppingCar")
	public ModelAndView deleteShoppingCar(String id, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		boolean deleteShoppingCar = userOrderService.deleteShoppingCar(Integer.parseInt(id));
		if (deleteShoppingCar) {
			User user = (User) session.getAttribute("user");
			int count = userOrderDao.countshopping(user);
			String curPage = (String) session.getAttribute("curPage");
			int pageSize = (int) session.getAttribute("pageSize");
			if (count % pageSize == 0) {
				int a = Integer.parseInt(curPage) - 1;
				curPage = String.valueOf(a);
			} else {
				if (null == curPage) {
					curPage = "1";
				} else {
					curPage = curPage;
				}
			}
			modelAndView.setViewName("selectShopping.do?curPage=" + curPage + "");
			modelAndView.addObject("deleteshoppingcar", "<script>alert('取消成功!')</script>");
		}
		return modelAndView;
	}

	@RequestMapping(value = "updateShoppingCar")
	@ResponseBody
	public void updateShoppingCar(HttpSession session, String id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		String productsum = request.getParameter("productsum");
		boolean updateShoppingCar = userOrderService.updateShoppingCar(Integer.parseInt(id),
				Integer.parseInt(productsum));
		if (updateShoppingCar) {
			String curPage = (String) session.getAttribute("curPage");
			if (null == curPage) {
				curPage = "1";
			} else {
				curPage = curPage;
			}
			modelAndView.setViewName("selectShopping.do?curPage=" + curPage + "");
			response.getWriter().print("{\"res\": 1, \"data\":\"订单提交成功\",\"curPage\": " + curPage + "}");

			modelAndView.addObject("deleteshoppingcar", "<script>alert('订单提交成功!')</script>");
		} else {
			response.getWriter().print("{\"res\": 0, \"data\":\"订单提交失败\"}");
		}
	}

	@RequestMapping(value = "updateProductsum")
	@ResponseBody
	public void updateProductsum(HttpSession session, String id, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String productsum = request.getParameter("productsum");
		ModelAndView modelAndView = new ModelAndView();
		boolean updateProductsum = userOrderService.updateProductsum(Integer.parseInt(id),
				Integer.parseInt(productsum));
		if (updateProductsum) {
			String curPage = (String) session.getAttribute("curPage");
			if (null == curPage) {
				curPage = "1";
			} else {
				curPage = curPage;
			}
			response.getWriter().print("{\"res\": 1, \"data\":\"订单提交成功\",\"curPage\": " + curPage + "}");
			modelAndView.setViewName("selectShopping.do?curPage=" + curPage + "");
		} else {
			response.getWriter().print("{\"res\": 0");
		}
	}

	@RequestMapping(value = "deleteShoppingindex")
	public ModelAndView deleteShoppingindex(HttpSession session, String id) {
		ModelAndView modelAndView = new ModelAndView();
		boolean deleteShoppingCar = userOrderService.deleteShoppingCar(Integer.parseInt(id));
		if (deleteShoppingCar) {
			User user = (User) session.getAttribute("user");
			modelAndView.setViewName("indexInfo.do");
			modelAndView.addObject("deleteshoppingcar", "<script>alert('取消成功!')</script>");
		}
		return modelAndView;
	}

	@RequestMapping(value = "updateshopping")
	public ModelAndView updateshopping(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("user");
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// 可以方便地修改日期格式
		String times = dateFormat.format(now);
		boolean updateShopping = userOrderService.updateShopping(user, times);
		if (updateShopping) {
			modelAndView.setViewName("selectShopping.do");
			modelAndView.addObject("deleteshoppingcar", "<script>alert('订单全部提交成功!')</script>");
		}
		return modelAndView;
	}

	@RequestMapping(value = "deleteshopping")
	public ModelAndView deleteshopping(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("user");
		boolean deteleShopping = userOrderService.deteleShopping(user);
		if (deteleShopping) {
			modelAndView.setViewName("selectShopping.do");
			modelAndView.addObject("deleteshoppingcar", "<script>alert('全部取消成功!')</script>");
		}
		return modelAndView;
	}
}
