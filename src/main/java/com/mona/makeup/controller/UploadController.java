package com.mona.makeup.controller;

import com.alibaba.fastjson.JSONObject;
import com.mona.makeup.pojo.Product;
import com.mona.makeup.utils.FileUpload;
import com.mona.makeup.utils.UserTools;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.net.SyslogAppender;
import org.hibernate.loader.custom.Return;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//显示图片
@Controller
public class UploadController extends BaseController {

   /* private  String picpath=System.getProperties().getProperty("user.home")+"/Pictures";*/

    @RequestMapping(value = "upload.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public void upload(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception {
        System.out.println("开始");
        ModelAndView modelAndView = new ModelAndView();
        FileUpload fileUpload = new FileUpload(request);
		// 设置上传目录
		fileUpload.setPath("upload");
		session.setAttribute("upload",fileUpload.getPath());
		// 设置文件类型
		fileUpload.setTypeReg("[.]jpg|png|jpeg|gif$");
		
		// 初始化表单参数
		int res = fileUpload.initFormData();
		
		if (res == 1){
			String file = fileUpload.getParameter("file");
			
			// 获取当前用户对象
			session.setAttribute("file",file);
			Product sessionUser =(Product) session.getAttribute("product");
			Product product = sessionUser.clone();
			product.setImgpath(file);
			// 更新
			boolean updateProduct = productService.updateProduct(product);
			if(updateProduct){
				res = 1;
			}
			
			if (res > 0){
				// 更新Session
				session.setAttribute("product", product);
				modelAndView.addObject("product", product);
				response.getWriter().print("{\"res\": 1, \"data\":\"图片上传成功\"}");
			}
			else{
				response.getWriter().print("{\"res\": "+ res +", \"info\":\"数据库操作失败!\"}");
			}
			
		}
		else if (res == -2){
			response.getWriter().print("{\"res\": "+ res +", \"info\":\"文件类型不允许!\"}");
		}
		else {
			response.getWriter().print("{\"res\": "+ res +", \"info\":\"文件上传失败!\"}");
		}

    }
  

}