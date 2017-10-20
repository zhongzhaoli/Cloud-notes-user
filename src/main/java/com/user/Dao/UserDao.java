package com.user.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.user.Entity.User;


//组件
@Component
//事务管理器
@Transactional
public class UserDao {

	//注入实体管理器
	@PersistenceContext
	private EntityManager entityManager;
	
	//获取数据库连接对象
	public Session getSession(){
		return entityManager.unwrap(Session.class);
	}
	
	public User findByAccount(String account){
		User user = getSession().get(User.class, account);
		return user;
	}
}
