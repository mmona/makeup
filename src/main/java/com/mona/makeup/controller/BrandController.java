package com.mona.makeup.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mona.makeup.bean.jsonresponse.JSONResponseBody;
import com.mona.makeup.dao.BrandDao;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Brand;
import com.mona.makeup.utils.StringUtils;

@Controller
public class BrandController extends BaseController {
	@Autowired
	private BrandDao brandDao;

	@RequestMapping(value = "selectBrand")
	public ModelAndView selectBrand(String curPage, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		boolean blank = StringUtils.isBlank(curPage);
		int cPage = 0;
		if (blank) {
			cPage = 1;
		} else {
			cPage = Integer.parseInt(curPage);
		}
		Result<Brand> selectBrand = brandService.selectBrand(cPage);
		if (selectBrand != null) {
			int pageSize = selectBrand.getPage().getPageSize();
			session.setAttribute("pageSize", pageSize);
			session.setAttribute("curPage", curPage);
			modelAndView.addObject("result", selectBrand);
			modelAndView.setViewName("admin/brand.jsp");
		}
		return modelAndView;
	}

	@RequestMapping(value = "selectBrandById")
	public ModelAndView selectBrandById(String id) {
		ModelAndView modelAndView = new ModelAndView();
		Brand brand = brandService.selectBranfById(Integer.parseInt(id));
		if (brand != null) {
			modelAndView.setViewName("admin/brand_update.jsp");
			modelAndView.addObject("brand", brand);
		}
		return modelAndView;
	}

	@RequestMapping(value = "updateBrand")
	public ModelAndView updateBrand(String bname, String id, String description, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Brand brand = new Brand();
		brand.setBname(bname);
		brand.setDescription(description);
		brand.setId(Integer.parseInt(id));
		boolean updateBrand = brandService.updateBrand(brand);
		if (updateBrand) {
			String curPage = (String) session.getAttribute("curPage");
			if(null== curPage ){
				curPage="1";
			}else{
				curPage = curPage;
			}
			modelAndView.setViewName("selectBrand.do?curPage=" + curPage + "");
			modelAndView.addObject("update", "<script>alert('品牌修改成功!')</script>");
		}
		return modelAndView;
	}

	@RequestMapping(value = "deleteBrand")
	public ModelAndView deleteBrand(String id, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		boolean deleteBrand = brandService.deleteBrand(Integer.parseInt(id));
		if (deleteBrand) {
			int countBrand = brandDao.countBrand();
			String curPage = (String) session.getAttribute("curPage");
			int pageSize = (int) session.getAttribute("pageSize");
			if (countBrand % pageSize == 0) {
				int a = Integer.parseInt(curPage) - 1;
				curPage = String.valueOf(a);
			} else {
				if(null== curPage ){
					curPage="1";
				}else{
					curPage = curPage;
				}
			}
			modelAndView.setViewName("selectBrand.do?curPage=" + curPage + "");
			modelAndView.addObject("update", "<script>alert('品牌删除成功!')</script>");
		}
		return modelAndView;
	}

	@RequestMapping(value = "addBrand")
	@Transactional
	public ModelAndView addBrand(String bname, String description, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Brand brand = new Brand();
		brand.setBname(bname);
		brand.setDescription(description);
		boolean addBrand = brandService.addBrand(brand);
		if (addBrand) {
			modelAndView.setViewName("selectBrand.do");
			modelAndView.addObject("update", "<script>alert('品牌添加成功!')</script>");
		}
		return modelAndView;
	}

	@RequestMapping(value = "brandInfo")
	@ResponseBody
	public String  brandInfo() {
		List<Brand> brandinfo = brandService.brandinfo();
		Gson gson = new Gson();
		String  json  = gson.toJson(brandinfo);
		return json;
	}

}
