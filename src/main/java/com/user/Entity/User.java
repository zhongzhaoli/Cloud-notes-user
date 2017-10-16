package com.user.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity  //表明该类是ejb的实体bean
public class User {
	@Id //主键
	private String id;
	private String account;
	private String pass;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}
