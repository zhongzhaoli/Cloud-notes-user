package com.user.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Userform {
	@Size(min=3,message="不少于3个字符")
	@NotNull(message="不能为空")
	private String account;
	@Size(min=3,message="不少于3个字符")
	@NotNull(message="不能为空")
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
