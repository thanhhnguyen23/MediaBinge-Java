package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.User;
import com.revature.services.UserService;

public class MediaBingeDriver {
	private static UserService service;
	
	@Autowired
	public MediaBingeDriver(UserService userService) {
		this.service = userService;
	}
	
	

	public static void main(String[] args) {

		// test mysql connection
		/////////////////////////
		
		

		
//		User person = new User("supafly","Tabitha", "Wintward","09876");
//		System.out.println(person);
//		System.out.println(service.add(person));

		
		
	}
}
