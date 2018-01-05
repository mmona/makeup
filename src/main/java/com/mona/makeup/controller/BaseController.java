package com.mona.makeup.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.mona.makeup.service.AdminService;




public class BaseController {
	@Autowired
	protected AdminService adminService;
	
	
	
	
}
