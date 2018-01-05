package com.mona.makeup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mona.makeup.pojo.Admin;
import com.mona.makeup.pojo.User;

@Controller
@RequestMapping(value="/admin")
public class AdminController extends BaseController {
	@RequestMapping(value="/login")
	public ModelAndView login(String name,String pwd,HttpServletRequest request,HttpSession session){
		String method = request.getMethod();
		Admin admin  = new Admin();
		admin.setName(name);;
		admin.setPassword(pwd);
		if("get".equalsIgnoreCase(method)){
			 admin=(Admin) session.getAttribute("admin");
		}else{
		session.setAttribute("admin", admin);
		}
		ModelAndView mView = new ModelAndView();
		Admin admin1 = adminService.login(admin);
		if( admin1!=null){
			session.setAttribute("admin", admin1);
			mView.addObject("admin",admin1);
			mView.setViewName("/admin/main.jsp");
			return mView;
		}
		return null;
	}
}
