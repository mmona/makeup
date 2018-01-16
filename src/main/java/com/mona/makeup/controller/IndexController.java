package com.mona.makeup.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.engine.jdbc.spi.ResultSetReturn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.mona.makeup.pojo.Orderr;
import com.mona.makeup.pojo.User;

@Controller
@RequestMapping(value = "/qiantai")
public class IndexController extends BaseController {
	@RequestMapping(value="indexshopping",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String indexshopping(HttpSession session){

		User user = (User) session.getAttribute("user");
		List<Orderr> indexshopping = userOrderService.indexshopping(user);
		/*JSONArray arr = JSONArray.t( indexshopping);*/
		/*Gson gson = new Gson();
		String  json  = gson.toJson(indexshopping);
		JSONObject object = new JSONObject();
		object.toJSON(indexshopping);
		System.out.println(json);
		return object;*/
		String json =  JSONObject.toJSON(indexshopping).toString();
		return json;
	}
}
