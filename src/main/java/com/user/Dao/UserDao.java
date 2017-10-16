package com.user.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.commons.codec.binary.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.user.Entity.User;


@Repository //据访问层
@Transactional
public class UserDao {
	@PersistenceContext
	private EntityManager entityManager;

	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
  
	public void save(User user){
		getSession().save(user);
	}
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
}
