package com.user.Controller;

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
	
	//注册页面
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	
	//第三方登录，
	@RequestMapping("/wxine")
	public String wxine(){
		return "wxine";
	}
	
	//注册
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String register_in(){
		return "login";
	}
}
	