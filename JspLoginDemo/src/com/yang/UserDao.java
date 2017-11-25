package com.yang;

public class UserDao {
	public boolean userLogin(User user)
	{
		if("admin".equals(user.getUsername())&&"admin".equals(user.getPassword()))
		{
			return true;
		}
		return false;
	}
}
