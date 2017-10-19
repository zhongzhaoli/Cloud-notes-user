package com.user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class UserController {
	
	
	//登录页面
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	//第三方登录，
	@RequestMapping("/wxine")
	public String wxine(){
		return "wxine";
	}
}
	