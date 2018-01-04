package com.mona.makeup.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mona.makeup.pojo.User;

@Controller
@RequestMapping(value="/admin")
public class UserController extends BaseController {
	@RequestMapping(value="/login")
	public ModelAndView login(String name,String pwd){
		User user  = new User();
		user.setUsername(name);
		user.setPassword(pwd);
		ModelAndView mView = new ModelAndView();
		User admin = userService.login(user);
		if(user!=null){
			mView.addObject("admin",admin);
			System.out.println(admin.getUsername());
			mView.setViewName("/admin/main.jsp");
			return mView;
		}
		return null;
	}
}
