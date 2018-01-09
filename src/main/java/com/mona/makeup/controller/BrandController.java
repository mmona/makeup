package com.mona.makeup.controller;

import java.awt.Dialog.ModalityType;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
			int beginIndex = selectBrand.getPage().getBeginIndex();
			int totalPage = selectBrand.getPage().getTotalPage();
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
			String  curPage = (String) session.getAttribute("curPage");
			modelAndView.setViewName("selectBrand.do?curPage=" + curPage + "");
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
			if (countBrand%pageSize==0) {
				int a = Integer.parseInt(curPage) - 1;
				curPage = String.valueOf(a);
			} else {
				curPage = curPage;
			}
			modelAndView.setViewName("selectBrand.do?curPage=" + curPage + "");
		}
		return modelAndView;
	}
	@RequestMapping(value="addBrand")
	@Transactional
	public ModelAndView addBrand(String bname,String description,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		Brand brand = new Brand();
		brand.setBname(bname);
		brand.setDescription(description);
		boolean addBrand = brandService.addBrand(brand);
		if(addBrand ){
			modelAndView.setViewName("selectBrand.do");
		}
		return modelAndView;
	}
}
