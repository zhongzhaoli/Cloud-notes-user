package com.user.Controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
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
	
	@RequestMapping("/index")
	public String index(HttpSession session){
		if(session.getAttribute("user")!=null){
			return "index";
		}
		else{
			return "login";
		}
	}
	
	@RequestMapping(value="/userlist",method=RequestMethod.GET)
	public String userlist(HttpSession session,Model m){
		if(session.getAttribute("user")!=null){
			List<User> userlist = userdao.userlist();
			String getuser=(String) session.getAttribute("user");
			m.addAttribute("userlist",userlist);
			if(StringUtils.equals(getuser, "admin")){ //管理员账号
				return "userlist";
			}
			return "redirect:/index";
		}
		return "login";
	}
}
