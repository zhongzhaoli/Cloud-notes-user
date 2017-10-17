package com.user.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.alibaba.fastjson.JSON;
import com.user.Dao.UserDao;
import com.user.Entity.User;
import com.user.Util.MD5;
import com.user.form.JsonResult;
import com.user.form.Userform;

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
	@ResponseBody //返回的是字符串不是网页
	@RequestMapping(value="/login_java",method=RequestMethod.GET)
	public String login(HttpSession session,@Valid Userform userForm, BindingResult result){
		List<JsonResult> arr = new ArrayList<JsonResult>();
		if(result.hasErrors()){
			List<ObjectError> list = result.getAllErrors();//getAllErrors获取所有错误的类型放进List里
			for(ObjectError error : list){
				JsonResult jr=new JsonResult();
				FieldError fe = (FieldError)error;
				jr.setField(fe.getField());
				jr.setMessage(fe.getDefaultMessage());
				arr.add(jr);
			}
		}
		else{
			User user = userdao.findByAccount(userForm.getAccount());
			if(user==null){
				return "hasno_account";
			}
			else{
				String result1=userdao.auth(userForm.getAccount(), md5.setmd5(userForm.getPass()));
				if(StringUtils.equals(result1,"success")){
					session.setAttribute("user",userForm.getAccount());
				}
				return result1;
			}
		}
		return JSON.toJSONString(arr);
	}
	@RequestMapping(value="/delete_user",method=RequestMethod.DELETE)
	public String del_user(String userid){
		User user=userdao.findId(userid);
		userdao.del_user(user);
		return "userlist";
	}
}
