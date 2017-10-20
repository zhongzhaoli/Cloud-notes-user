package com.user.Controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm {
	@NotNull(message="不能为空")
	@Size(min=3,message="不少于3个字符")
	private String account;
	@NotNull(message="不能为空")
	@Size(min=3,message="不少于3个字符")
	private String pass;
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
