package com.user.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.user.Entity.User;
import com.user.Util.ServiceException;

@Controller
public class UserController {
	
	User user=new User();
	
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
	@ResponseBody //返回的是字符串不是网页
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String register_in(@Valid RegisterForm RegisterForm, BindingResult result){
		if(result.hasErrors()){
			List<JsonResult> arr = new ArrayList<JsonResult>();
			List<ObjectError> list = result.getAllErrors();//getAllErrors获取所有错误的类型放进List里
			for(ObjectError error : list){
				JsonResult jr=new JsonResult();
				FieldError fe = (FieldError)error;
				jr.setField(fe.getField());
				jr.setMessage(fe.getDefaultMessage());
				arr.add(jr);
			}
			return JSON.toJSONString(arr);
		}
		user.setId(UUID.randomUUID().toString().replace("-", ""));
		user.setUsername(RegisterForm.getAccount());
		user.setPassword(RegisterForm.getPassword());
		if(!StringUtils.equals(RegisterForm.getPassword2(),RegisterForm.getPassword())){
			throw new ServiceException("password2","pass2.error");
		}
		return "login";
	}
}
	