package com.mona.makeup.controller;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.manager.util.SessionUtils;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mona.makeup.dao.UserDao;
import com.mona.makeup.page.utils.Page;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.User;
import com.mona.makeup.service.UserService;
import com.mona.makeup.utils.StringUtils;
import com.mysql.jdbc.StreamingNotifiable;
@Controller
public class UserController extends BaseController{
	@Autowired
	private UserDao usrDao;
	@RequestMapping(value="seletAllUser")
	public ModelAndView selectUser(String curPage,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		int cPage = (curPage!=null)?Integer.parseInt(curPage):1;
		Result<User> selectUser = userService.selectUser(cPage);
		if(selectUser!=null){
			int pageSize = selectUser.getPage().getPageSize();
			int beginIndex = selectUser.getPage().getBeginIndex();
			int totalPage = selectUser.getPage().getTotalPage();
			session.setAttribute("pageSize", pageSize);
			modelAndView.addObject("result", selectUser);
			modelAndView.setViewName("admin/userManager.jsp");
			session.setAttribute("curPage",curPage);
		}
		return modelAndView;
	}
	@RequestMapping(value="selectUserById")
	public ModelAndView selectUserById(String id){
		ModelAndView modelAndView = new ModelAndView();
		User user = userService.selectUserById(Integer.parseInt(id));
		modelAndView.addObject("user", user);
		modelAndView.setViewName("admin/user_update.jsp");
		return modelAndView;
	}
	@RequestMapping(value="updateUserById")
	@Transactional
	public ModelAndView updateUserById(HttpSession session,	String username,String password,String realname,String age,String address,String card,String telephone,String email,String code,String id){
		ModelAndView modelAndView = new ModelAndView();
		User user  = new User();
		user.setId(Integer.parseInt(id));
		user.setUsername(username);
		user.setPassword(password);
		user.setRealname(realname);
		user.setAge(age);
		user.setAddress(address);
		user.setCard(card);
		user.setCode(code);
		user.setEmail(email);
		user.setTelephone(telephone);
		boolean idUpdate = userService.updateUserById(user);
		if(idUpdate){
			String  curPage  = (String) session.getAttribute("curPage");
			if(null== curPage ){
				curPage="1";
			}else{
				curPage = curPage;
			}
			modelAndView.setViewName("seletAllUser.do?curPage="+curPage+"");
			modelAndView.addObject("update", "<script>alert('修改成功!')</script>");
		}
		return modelAndView;
	}
	@RequestMapping(value="deleteUserById")
	@Transactional
	public ModelAndView deleteUserById(String id,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		boolean isDelete = userService.deleteUserById(Integer.parseInt(id));
		if(isDelete){
			String  curPage  = (String)session.getAttribute("curPage");
			int  pageSize = (int) session.getAttribute("pageSize");
			int userCount = usrDao.selectUserCount();
			if(userCount%pageSize==0){
				int a = Integer.parseInt(curPage)-1;
				curPage = String.valueOf(a);
			}else {
				if(null== curPage ){
					curPage="1";
				}else{
					curPage = curPage;
				}
			}
			modelAndView.setViewName("seletAllUser.do?curPage="+curPage+"");
			modelAndView.addObject("update", "<script>alert('删除成功!')</script>");
		}
		return modelAndView;
	}

	
}
