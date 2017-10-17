package com.user.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.Dao.UserDao;
import com.user.Entity.User;
import com.user.Util.MD5;
import java.util.List;

@Controller //定义一个控制器
public class MessController {
	
	@Autowired //自动注入
	private UserDao userdao;
	
	User user=new User();
	MD5 md5 = new MD5();
	
	@RequestMapping(value="/userlist",method=RequestMethod.GET)
	public String userlist(HttpSession session,Model m){
		if(session.getAttribute("user")!=null){
			List<User> userlist = userdao.userlist();
			m.addAttribute("userlist",userlist);
			return "userlist";
		}
		return "login";
	}
}
