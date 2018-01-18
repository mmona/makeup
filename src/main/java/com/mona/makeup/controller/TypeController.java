package com.mona.makeup.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mona.makeup.bean.jsonresponse.JSONResponseBody;
import com.mona.makeup.dao.TypeDao;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Type;
import com.mona.makeup.utils.StringUtils;

@Controller
public class TypeController extends BaseController{
	@Autowired
	private TypeDao typeDao;
	@RequestMapping(value="selectType")
	@Transactional
	public ModelAndView selectType(String curPage,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		boolean blank = StringUtils.isBlank(curPage);
		int cPage=0;
		if( blank){
			cPage=1;
		}else {
			cPage=Integer.parseInt(curPage);
		}
		
		Result<Type> selectType = typeService.selectType(cPage);
		if(selectType!=null){
			int pageSize = selectType.getPage().getPageSize();
			session.setAttribute("pageSize", pageSize);
			session.setAttribute("curPage",curPage);
			modelAndView.addObject("result", selectType);
			modelAndView.setViewName("admin/type.jsp");
		}
		
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="addType")
	public ModelAndView addType(String tname,String description,HttpSession session){
		ModelAndView modelAndView= new ModelAndView();
		Type type = new Type();
		type.setDescription(description);
		type.setTname(tname);
	
		boolean addType = typeService.addType(type);
		if(addType){
		
			modelAndView.setViewName("selectType.do");
			modelAndView.addObject("update", "<script>alert('类别添加成功!')</script>");
		}
		return modelAndView;
	}
	@RequestMapping(value="selectTypeById")
	public ModelAndView  selectTypeById(String id,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		Type selectTypeById = typeService.selectTypeById(Integer.parseInt(id));
		if(selectTypeById!=null){
			modelAndView.addObject("type", selectTypeById);
			modelAndView.setViewName("admin/type_update.jsp");
		}
		return modelAndView;
	}
	@RequestMapping(value="updateType")
	public ModelAndView updateType(String id,String tname,String description,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		Type type = new Type();
		type.setDescription(description);
		type.setId(Integer.parseInt(id));
		type.setTname(tname);
		boolean updateType = typeService.updateType(type);
		if(updateType){
			String  curPage = (String) session.getAttribute("curPage");
			if(null== curPage ){
				curPage="1";
			}else{
				curPage = curPage;
			}
			modelAndView.setViewName("selectType.do?curPage="+curPage+"");
			modelAndView.addObject("update", "<script>alert('类别修改成功!')</script>");
		}
		return modelAndView;
	}
	@RequestMapping(value="deleteType")
	public ModelAndView deleteType(String id,HttpSession session){
		ModelAndView modelAndView= new ModelAndView();
		boolean deleteType = typeService.deleteType(Integer.parseInt(id));
		if(deleteType){
			int countType = typeDao.countType();
			String  curPage  = (String)session.getAttribute("curPage");
			int  pageSize = (int) session.getAttribute("pageSize");
			if(countType%pageSize==0){
				int a = Integer.parseInt(curPage)-1;
				curPage = String.valueOf(a);
			}else {
				if(null== curPage ){
					curPage="1";
				}else{
					curPage = curPage;
				}
			}
			modelAndView.setViewName("selectType.do?curPage="+curPage+"");
			modelAndView.addObject("update", "<script>alert('类别删除成功!')</script>");
		}

		return modelAndView;
	}
	@RequestMapping(value="typeInfo")
	@ResponseBody
	public String typeInfo(){
		List<Type> typeInfo = typeService.typeInfo();
			Gson gson = new Gson();
			String  json  = gson.toJson(typeInfo);
			return json;
	}
}
