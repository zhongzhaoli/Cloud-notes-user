package com.user.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	