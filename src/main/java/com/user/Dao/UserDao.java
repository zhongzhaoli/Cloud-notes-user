package com.user.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import com.user.Entity.User;


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
	//登录
	public String auth(String account,String password){
		 DetachedCriteria dc=DetachedCriteria.forClass(User.class); //离线查询
		 dc.add(Property.forName("account").eq(account));
		 Criteria criteria=dc.getExecutableCriteria(getSession());
		 List list=criteria.list();
		 if(list!=null&&list.size()>0){
			 User user=(User) list.get(0);
			 if(user!=null&&StringUtils.equals(password, user.getPass())){
				 return "success";
			 }
			 else{
				 return "password_is_error";
			 }
		 }else{
			 return "account_is_error";
		 }
	}
	//全部user
	public List<User> userlist(){
		 DetachedCriteria dc=DetachedCriteria.forClass(User.class); //离线查询
		 Criteria criteria=dc.getExecutableCriteria(getSession());
		 List list=criteria.list();
		 return list;
	}
	//通过userid 找到user全部信息 存进实体类
	public User findId(String id){
		User user = getSession().get(User.class, id);
		return user;
	}
	//删除用户
	public void del_user(User user){
		getSession().delete(user);
	}
	//查看是否存在此用户
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
}
