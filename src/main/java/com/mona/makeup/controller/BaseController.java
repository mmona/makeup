package com.mona.makeup.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.mona.makeup.service.UserService;



public class BaseController {
	@Autowired
	protected UserService userService;
	
	
	
	
}
