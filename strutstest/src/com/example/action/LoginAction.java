package com.example.action;

import com.example.po.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();;
	public String login() {
		
		System.out.println(user.getUsername());
		System.out.println(user.getBooks().get(0));
		return SUCCESS;
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	@Override
	public void validate() {
		if(user.getUsername() == null || "".equals(user.getUsername())) {
			this.addFieldError("username", "用户名为空");
		}
	}
	
	
	
}
