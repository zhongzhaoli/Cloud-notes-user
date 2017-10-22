package com.user.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.user.Dao.UserDao;
import com.user.Entity.User;
import com.user.Util.MD5;
import com.user.Util.ServiceException;

public class UserService {
	@Autowired
	private UserDao userDao;
	
	MD5 md5 = new MD5();

	public boolean login(String account, String password){
		User user = userDao.findByAccount(account);
		String new_pass = md5.setmd5(password);
		if(new_pass.equals(user.getPassword())){
			return true;
		}else{
			throw new ServiceException("password","password.has.not.error");	
		}
	}
}
