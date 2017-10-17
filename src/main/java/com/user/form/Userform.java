package com.user.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Userform {
	@NotNull(message="不能为空")
	@Size(min=6,message="不少于6个字符")
	private String account;
	@NotNull(message="不能为空")
	@Size(min=6,message="不少于6个字符")
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