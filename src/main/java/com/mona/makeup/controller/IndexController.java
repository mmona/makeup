package com.mona.makeup.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.engine.jdbc.spi.ResultSetReturn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Orderr;
import com.mona.makeup.pojo.Product;
import com.mona.makeup.pojo.Type;
import com.mona.makeup.pojo.User;
import com.mona.makeup.utils.StringUtils;

@Controller
@RequestMapping(value = "/qiantai")
public class IndexController extends BaseController {
	@RequestMapping(value = "indexInfo")
	public ModelAndView indexInf(HttpSession session, String curPage, String name, String tid,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		List<Product> selectRecommend = userOrderService.selectRecommend();
		modelAndView.addObject("recommend", selectRecommend);
		User user = (User) session.getAttribute("user");
		List<Orderr> indexshopping = userOrderService.indexshopping(user);
		modelAndView.addObject("indexShopping", indexshopping);
		List<Type> typeInfo = typeService.typeInfo();
		modelAndView.addObject("type", typeInfo);
		session.removeAttribute("name");
		boolean blank = StringUtils.isBlank(curPage);
		int cPage = 0;
		if (blank) {
			cPage = 1;
		} else {
			cPage = Integer.parseInt(curPage);
		}
	
		String method = request.getMethod();
		if ("get".equalsIgnoreCase(method)) {
			name = (String) session.getAttribute("name");
			
		} else {
			session.setAttribute("name", name);
			
		}
		Result<Product> selectProduct = null;
		if (!"".equals(name) && name != null) {
			selectProduct = productService.selectProduct(cPage, name, null);
		} else if (!"".equals(tid) && tid != null) {
			Type type = typeService.selectTypeById(Integer.parseInt(tid));
			selectProduct = productService.selectProduct(cPage, null, type);
		} else {
			selectProduct = productService.selectProduct(cPage, null, null);
		}
		if (selectProduct != null) {
			modelAndView.addObject("result", selectProduct);
		}

		modelAndView.setViewName("index.jsp");
		return modelAndView;
	}

	@RequestMapping(value = "updateindexshopping")
	public ModelAndView updateindexshopping(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("user");
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// 可以方便地修改日期格式
		String times = dateFormat.format(now);
		boolean updateShopping = userOrderService.updateShopping(user, times);
		if (updateShopping) {
			modelAndView.setViewName("indexInfo.do");
			modelAndView.addObject("deleteshoppingcar", "<script>alert('订单提交成功!')</script>");
		}
		return modelAndView;
	}

	@RequestMapping(value = "deleteindexshopping")
	public ModelAndView deleteshopping(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("user");
		boolean deteleShopping = userOrderService.deteleShopping(user);
		if (deteleShopping) {
			modelAndView.setViewName("indexInfo.do");
			modelAndView.addObject("deleteshoppingcar", "<script>alert('全部取消成功!')</script>");
		}
		return modelAndView;
	}

	@RequestMapping(value = "addShoppingCar")
	public ModelAndView addShoppingCar(String id, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Product selectProductById = productService.selectProductById(Integer.parseInt(id));
		
		User user = (User) session.getAttribute("user");
		Orderr orderr = userOrderService.selectShoppingByProduct(selectProductById,user);
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// 可以方便地修改日期格式
		String times = dateFormat.format(now);
		boolean addShoppingCar=false;
		if(orderr!=null){
			int sum = orderr.getProductsum();
			int productsum = sum+1;
			addShoppingCar = userOrderService.updateProductsum(orderr.getId(), productsum);
		}else{
			orderr = new Orderr();
			int productsum =1;
			orderr.setProductsum(productsum);
			orderr.setProduct(selectProductById);
			orderr.setUser(user);
			orderr.setTimes(times);
			addShoppingCar = userOrderService.addShoppingCar(orderr);
		}
		
		
		if (addShoppingCar) {
			modelAndView.setViewName("indexInfo.do");
			modelAndView.addObject("deleteshoppingcar", "<script>alert('加入购物车!')</script>");
		}
		return modelAndView;
	}

	@RequestMapping(value = "selectProducrInfo")
	public ModelAndView selectProducrInfo(String id) {
		ModelAndView modelAndView = new ModelAndView();
		Product selectProductById = productService.selectProductById(Integer.parseInt(id));
		if (selectProductById != null) {
			modelAndView.setViewName("show.jsp");
			modelAndView.addObject("product", selectProductById);
		}
		return modelAndView;
	}

}
