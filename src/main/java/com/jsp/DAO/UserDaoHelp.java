package com.jsp.DAO;

public class UserDaoHelp
{
	public static UserDao userDao()
	{
		UserDao userDao=new UserDaoImplementation();
		return userDao;
	}
}
