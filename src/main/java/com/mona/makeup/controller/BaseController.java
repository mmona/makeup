package com.mona.makeup.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.mona.makeup.service.AdminService;
import com.mona.makeup.service.BrandService;
import com.mona.makeup.service.OrderService;
import com.mona.makeup.service.QuestionService;
import com.mona.makeup.service.ReviewService;
import com.mona.makeup.service.TypeService;
import com.mona.makeup.service.UserService;




public class BaseController {
	@Autowired
	protected AdminService adminService;
	@Autowired
	protected UserService userService;
	@Autowired
	protected TypeService typeService;
	@Autowired
	protected BrandService brandService;
	@Autowired
	protected QuestionService questionService;
	@Autowired
	protected ReviewService reviewService;
	@Autowired
	protected OrderService orderService;
	
}
