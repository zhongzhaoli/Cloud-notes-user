package com.user.Dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.user.Entity.User;


//组件
@Component
//事务管理器
@Repository //据访问层
@Transactional
public class UserDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	//注册
	public void save(User user){
		getSession().save(user);
	}
	//检测是否存在这个用户
	public User findByAccount(String account){
		 DetachedCriteria dc=DetachedCriteria.forClass(User.class); //离线查询
		 dc.add(Property.forName("account").eq(account));
		 Criteria criteria=dc.getExecutableCriteria(getSession());
		 List list=criteria.list();
		 if(list!=null&&list.size()>0){
			 return (User) list.get(0);
		 }
		 return null;
	}

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
