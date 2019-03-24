package com.revature.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.revature.models.Principal;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.util.JwtConfig;
import com.revature.util.JwtGenerator;

@RestController
@RequestMapping("")
public class LoginController {

private UserService service;
	
	@Autowired
	public LoginController(UserService userService) {
		this.service = userService;
	}
	
	@PostMapping(value = "/{username},{password}", produces=MediaType.APPLICATION_JSON_VALUE)
	public HttpServletResponse login(@PathVariable String username, @PathVariable String password, HttpServletResponse resp)
	{
		User user = service.getByCredentials(username, password);
		resp.addHeader(JwtConfig.HEADER, JwtConfig.PREFIX + JwtGenerator.createJwt(user));
		resp.addHeader("Info",Integer.toString(user.getId()));
		resp.addHeader("UserRole", Integer.toString(user.getRoleId()));
		resp.addHeader("UserFirstName", user.getFirstName());
		resp.addHeader("UserLastName", user.getLastName());
		resp.addHeader("UserName", user.getUsername());
		return resp;
		
		
	}
}
