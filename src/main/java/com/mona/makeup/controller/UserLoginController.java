package com.mona.makeup.controller;

import java.awt.Dialog.ModalExclusionType;
import java.awt.event.MouseAdapter;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mona.makeup.bean.jsonresponse.JSONResponseBody;
import com.mona.makeup.pojo.Admin;
import com.mona.makeup.pojo.User;

@Controller
@RequestMapping(value="/qiantai")
public class UserLoginController  extends BaseController{
	@RequestMapping(value="/login")
	public ModelAndView login(String username,String password,HttpServletRequest request,HttpSession session){
		ModelAndView modelAndView  = new ModelAndView();
		String method = request.getMethod();
		if("get".equalsIgnoreCase(method)){
			password=(String) session.getAttribute("password");
			username=(String) session.getAttribute("username");
		}else{
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		}
		User login = userService.login(username, password);
		if(login!=null){
			modelAndView.addObject("user", login);
			session.setAttribute("user",login);
			modelAndView.setViewName("index.jsp");
		}else {
			modelAndView.setViewName("login.jsp");
		}
		return modelAndView;
	}
	@RequestMapping(value="logout")
	public String logout(HttpSession session){
		String password=(String) session.getAttribute("password");
		String username=(String) session.getAttribute("username");
		User login = userService.login(username, password);
		if(login!=null){
			session.removeAttribute("user");
		}
		return "login.jsp";
	}
	@RequestMapping(value="selectUserByUsername")
	public ModelAndView selectUserByUsername(HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		String username=(String) session.getAttribute("username");
		User selectuserByname = userService.selectuserByname(username);
		if( selectuserByname!=null){
			modelAndView.setViewName("repassword.jsp");
			modelAndView.addObject("user", selectuserByname);
		}
		return modelAndView;
	}
	@RequestMapping(value="updatePassword")
	public ModelAndView  updatePassword(String pwd,String id){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		user.setPassword(pwd);
		user.setId(Integer.parseInt(id));
		boolean updatePassword = userService.updatePassword(user);
		if(updatePassword){
			modelAndView.setViewName("login.jsp");
			modelAndView.addObject("password", "<script>alert('密码重置完成，请重新登录!')</script>");
		}
		return modelAndView;
	}
	@RequestMapping(value="isUser")

	public ModelAndView isUser(String name){
		ModelAndView modelAndView = new ModelAndView();
		User selectuserByname = userService.selectuserByname(name);
		if(selectuserByname == null){
			modelAndView.setViewName("addUser.do");
		}else {
			modelAndView.addObject("error","<script>alert('用户名已存在,请重新输入!')</script>");
			modelAndView.setViewName("reg.jsp");
		}
		return modelAndView;
	}
	/*public String isAdd(String name){
		User selectuserByname = userService.selectuserByname(name);
		if(selectuserByname!=null){
			
		}
		return null;
	}*/
	@RequestMapping(value="addUser")
	public ModelAndView addUser(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		String name = request.getParameter("name");
		String password = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String realname = request.getParameter("realname");
		String age = request.getParameter("age");
		String card = request.getParameter("card");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String code= request.getParameter("code");
		User user  = new User();
		user.setUsername(name);
		user.setPassword(password);
		user.setRealname(realname);
		user.setSex(sex);
		user.setAddress(address);
		user.setAge(Integer.parseInt(age));
		user.setTelephone(phone);
		user.setEmail(email );
		user.setCard(card);
		user.setCode(code);
		boolean addUser = userService.addUser(user);
		if(addUser){
			modelAndView.setViewName("login.jsp");
			modelAndView.addObject("success","<script>alert('注册成功请登录!')</script>");
		}else {
			modelAndView.addObject("fail","<script>alert('注册失败!')</script>");
			modelAndView.setViewName("reg.jsp");
		}
		return modelAndView;
	}
	@RequestMapping(value="updateUser")
	public ModelAndView updateUser(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		String name = request.getParameter("name");
		String password = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String realname = request.getParameter("realname");
		String age = request.getParameter("age");
		String card = request.getParameter("card");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String code= request.getParameter("code");
		String id= request.getParameter("id");
		User user  = new User();
		user.setUsername(name);
		user.setPassword(password);
		user.setRealname(realname);
		user.setSex(sex);
		user.setAddress(address);
		user.setAge(Integer.parseInt(age));
		user.setTelephone(phone);
		user.setEmail(email );
		user.setCard(card);
		user.setCode(code);
		user.setId(Integer.parseInt(id));
		boolean updateUser = userService.updateUser(user);
		if(updateUser){
			modelAndView.setViewName("login.jsp");
			modelAndView.addObject("isupdate","<script>alert('个人信息修改成功请登录!')</script>");
		}else {
			modelAndView.addObject("unupdate","<script>alert('个人信息修改失败!')</script>");
			modelAndView.setViewName("reg.jsp");
		}
		return modelAndView;
	}
}
