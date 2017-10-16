package com.user.Controller;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.Dao.UserDao;
import com.user.Entity.User;
import com.user.Util.MD5;

@Controller //定义一个控制器
public class UserController {
	
	@Autowired //自动注入
	private UserDao userdao;
	
	User user=new User();
	MD5 md5 = new MD5();
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	@RequestMapping(value="/register_java",method=RequestMethod.POST)
	public String register(String account,String pass){
		user.setAccount(account);
		user.setId(UUID.randomUUID().toString().replace("-", ""));
		user.setPass(md5.setmd5(pass));
		userdao.save(user);
		return "redirect:/login";
	}
	
	@RequestMapping(value="/login_java",method=RequestMethod.GET)
	public String login(String account,String pass){
		user.setAccount(account);
		user.setPass(pass);
		String result=userdao.auth(account, md5.setmd5(pass));
		if(StringUtils.equals(result, "success")){
			return "redirect:/userlist";
		}
		return "login";
	}
}
