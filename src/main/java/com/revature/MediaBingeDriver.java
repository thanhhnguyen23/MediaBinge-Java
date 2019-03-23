package com.revature;

//import java.security.Provider.Service;

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
		
		User person = new User("supafly","Tabitha", "Wintward","09876");
		System.out.println(person);
		System.out.println(service.add(person));
		
		
	}
}
