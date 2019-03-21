package com.revature;

import com.revature.dao.UserDao;
import com.revature.models.User;

public class MediaBingeDriver {

	private static final UserDao userDao = new UserDao();

	public static void main(String[] args) {
		User user = new User(1, "test1", "firstName", "lastName", "p4ssword");

		System.out.println(user);
			
		userDao.add(user);
		
	}
}
