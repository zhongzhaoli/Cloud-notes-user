package com.user.Dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.netflix.config.Property;
import com.user.Entity.User;

import net.bytebuddy.agent.builder.AgentBuilder.RawMatcher.Disjunction;

public class UserDao {
	public User findByAccount(String username){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(User.class);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
