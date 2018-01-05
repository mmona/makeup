package com.mona.makeup.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.weaver.reflect.ReflectionBasedReferenceTypeDelegate;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mona.makeup.bean.jsonresponse.JSONResponseBody;
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
		}else {
			mView.setViewName("/admin/index.jsp");
			mView.addObject("error", "密码或用户名错误请重新登录");
		}
		return mView;
	}
	@RequestMapping(value="/selectAdmin")
	public ModelAndView selectAdminByid(String id){
		Admin admin = adminService.selectAdminById(Integer.parseInt(id));
		ModelAndView modelAndView  = new ModelAndView();
		modelAndView.addObject("admin", admin);
		modelAndView.setViewName("/admin/admin_update.jsp");
		return modelAndView;
	}
	@RequestMapping(value="/updateAdmin")
	@Transactional
	public ModelAndView updateAdmin(String name,String pwd,String id,HttpServletResponse response ) throws IOException{
		ModelAndView modelAndView = new ModelAndView();
		Admin admin = new Admin();
		admin.setId(Integer.parseInt(id));
		admin.setName(name);
		admin.setPassword(pwd);
		PrintWriter out = response.getWriter();
		boolean updateAdmin = adminService.updateAdmin(admin);
		if(updateAdmin){
			out.println("<script>alert('修改成功');</script>");
			modelAndView.setViewName("/admin/index.jsp");
		}else {
			out.println("<script>alert('修改失败');</script>");
		}
		return modelAndView;
	}
	
}
