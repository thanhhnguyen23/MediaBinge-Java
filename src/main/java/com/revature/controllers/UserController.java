package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService service;
	
	@Autowired
	public UserController(UserService userService) {
		this.service = userService;
	}
	
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAll(){
		return service.getAll();
	}

}
