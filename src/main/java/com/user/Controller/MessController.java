package com.user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.Dao.UserDao;
import com.user.Entity.User;
import com.user.Util.MD5;

@Controller //定义一个控制器
public class MessController {
	User user=new User();
	MD5 md5 = new MD5();
	
	@RequestMapping("/userlist")
	public String userlist(){
		return "userlist";
	}
}
