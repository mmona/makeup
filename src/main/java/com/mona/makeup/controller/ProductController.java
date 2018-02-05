package com.mona.makeup.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;

import org.apache.catalina.SessionIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mona.makeup.controller.BaseController;
import com.mona.makeup.dao.ProductDao;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Brand;
import com.mona.makeup.pojo.Product;
import com.mona.makeup.pojo.Type;
import com.mona.makeup.utils.StringUtils;

@Controller
public class ProductController extends BaseController{
	@Autowired
	private ProductDao productDao;
	@RequestMapping(value="selectProduct")
	public ModelAndView selectProduct(String curPage,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		boolean blank = StringUtils.isBlank(curPage);
		int cPage = 0;
		if (blank) {
			cPage = 1;
		} else {
			cPage = Integer.parseInt(curPage);
		}
		Result<Product> selectProduct = productService.selectProduct(cPage,null,null);
		if(selectProduct!=null){
			int pageSize = selectProduct.getPage().getPageSize();
			int beginIndex = selectProduct.getPage().getBeginIndex();
			int totalPage = selectProduct.getPage().getTotalPage();
			session.setAttribute("pageSize", pageSize);
			session.setAttribute("curPage", curPage);
			session.setAttribute("totalPage",totalPage);
			modelAndView.addObject("result",selectProduct);
			modelAndView.setViewName("admin/product.jsp");
		}
		return modelAndView;
	}
	@RequestMapping(value="selectProductById")
	public ModelAndView selectProductById(String id,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		Product selectProductById = productService.selectProductById(Integer.parseInt(id));
		List<Type> typeInfo = typeService.typeInfo();
		List<Brand> brandinfo = brandService.brandinfo();
		if(selectProductById!=null){
			modelAndView.setViewName("admin/product_update.jsp");
			modelAndView.addObject("product", selectProductById);
			modelAndView.addObject("type",  typeInfo );
			modelAndView.addObject("brand",brandinfo);
			session.setAttribute("product", selectProductById);
		}
		return modelAndView;
	}
	@RequestMapping(value="updateProduct")
	public ModelAndView updateProduct(HttpServletRequest request,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		String name = request.getParameter("name");
		String burden = request.getParameter("burden");
		String price1 = request.getParameter("price1");
		String price2 = request.getParameter("price2");
		String description = request.getParameter("description");
		String typeid = request.getParameter("typeid");
		String brandid = request.getParameter("brandid");
		String 	file = request.getParameter("file");
		File file1  = new File("file");
		String absolutePath = file1.getAbsolutePath();
		String id= request.getParameter("id");
		/*Product product = new Product();*/
		Product product = (Product) session.getAttribute("product");
		product.setBurden(burden);
		product.setDescription(description);
		product.setId(Integer.parseInt(id));
		String  attribute = (String) session.getAttribute("absolutePath");
		product.setImgpath(product.getImgpath() );
		product.setName(name);
		product.setPrice1(Float.parseFloat(price1));
		product.setPrice2(Float.parseFloat(price2));
		Type type = new Type();
		type.setId(Integer.parseInt(typeid));
		product.setType(type);
		Brand brand = new Brand();
		brand.setId(Integer.parseInt(brandid));
		product.setBrand(brand);
		/*product.setRecommend(product.getRecommend());*/
		boolean updateProduct = productService.updateProduct(product);
		if(updateProduct){
			String  curPage = (String) session.getAttribute("curPage");
			if(null== curPage ){
				curPage="1";
			}else{
				curPage = curPage;
			}
			modelAndView.setViewName("selectProduct.do?curPage="+curPage+"");
			modelAndView.addObject("update", "<script>alert('商品修改成功!')</script>");
		}
		return modelAndView;
	}
	//delete product
	@RequestMapping(value="deleteProductById")
	public ModelAndView deleteProduct(String id,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		boolean deleteProduct = productService.deleteProduct(Integer.parseInt(id));
		if(deleteProduct){
			int count = productDao.countProduct(null,null);
		
			String  curPage  = (String)session.getAttribute("curPage");
			int  pageSize = (int) session.getAttribute("pageSize");
			if(count%pageSize==0){
				int a = Integer.parseInt(curPage)-1;
				curPage = String.valueOf(a);
			}else {
				if(null== curPage ){
					curPage="1";
				}else{
					curPage = curPage;
				}
			}
			modelAndView.setViewName("selectProduct.do?curPage="+curPage+"");
			modelAndView.addObject("update", "<script>alert('商品删除成功!')</script>");
		}
		return modelAndView;
	}
	@RequestMapping(value="addProduct")
	public ModelAndView addProduct(HttpServletRequest request,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		String name = request.getParameter("name");
		String burden = request.getParameter("burden");
		String price1 = request.getParameter("price1");
		String price2 = request.getParameter("price2");
		String description = request.getParameter("description");
		String typeid = request.getParameter("typeid");
		String brandid = request.getParameter("brandid");
		String 	file = request.getParameter("file");
		File file1  = new File("file");
		String absolutePath = file1.getAbsolutePath();
		String id= request.getParameter("id");
		Product product = new Product();
		product.setBurden(burden);
		product.setDescription(description);
		String  attribute = (String) session.getAttribute("absolutePath");
	/*	product.setImgpath(file);*/
		product.setName(name);
		if(!"".equals(price1)){
			product.setPrice1(Float.parseFloat(price1));
		}
		if(!"".equals(price2)){
			product.setPrice2(Float.parseFloat(price2));
		}
		Type type = new Type();
		type.setId(Integer.parseInt(typeid));
		product.setType(type);
		Brand brand = new Brand();
		brand.setId(Integer.parseInt(brandid));
		product.setBrand(brand);
		boolean updateProduct = productService.addProduct(product);
		if(updateProduct){
			modelAndView.addObject("update", "<script>alert('商品添加成功!')</script>");
			modelAndView.setViewName("selectProduct.do");
		}
		return modelAndView;
	}
	@RequestMapping(value="updateRecommend")
	public ModelAndView updateRecommend(HttpSession session,String id ){
		ModelAndView modelAndView = new ModelAndView();
		Product product = productService.selectProductById(Integer.parseInt(id));
		int recommend = product.getRecommend();
		if(recommend==1){
			product.setRecommend(0);
		}else {
			product.setRecommend(1);
		}
		boolean updateProduct = productService.updateProduct(product);
		if(updateProduct){
			String  curPage = (String) session.getAttribute("curPage");
			if(null== curPage ){
				curPage="1";
			}else{
				curPage = curPage;
			}
			modelAndView.setViewName("selectProduct.do?curPage="+curPage+"");
			if(recommend==1){
				modelAndView.addObject("update", "<script>alert('商品取消推荐!')</script>");
			}else {
				modelAndView.addObject("update", "<script>alert('商品推荐成功!')</script>");
			}
			
		}
		return modelAndView;
	}
}
