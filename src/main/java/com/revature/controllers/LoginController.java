package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.revature.models.Principal;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.util.JwtConfig;
import com.revature.util.JwtGenerator;
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"content-type","Authorization"},exposedHeaders = {"Authorization","Info","Role","UserFirstName","UserLastName","UserName"}, methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/login")
public class LoginController {

private UserService service;
	
	@Autowired
	public LoginController(UserService userService) {
		this.service = userService;
	}
//	@ModelAttribute
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces="application/json")
	public User login(@RequestBody User credentials, HttpServletResponse resp)
	{
		System.out.println("Response:"+resp);
		User user = service.getByCredentials(credentials.getUsername(), credentials.getPassword());
		resp.setHeader(JwtConfig.HEADER, JwtConfig.PREFIX + JwtGenerator.createJwt(user));
		System.out.println(resp.getHeader(JwtConfig.HEADER));
		System.out.println(JwtConfig.HEADER);
		resp.addHeader("Info",Integer.toString(user.getId()));
		resp.addHeader("UserFirstName", user.getFirstName());
		resp.addHeader("Role", Integer.toString(user.getRole()));
		resp.addHeader("UserLastName", user.getlastName());
		resp.addHeader("UserName", user.getUsername());
		return user;
		
		
	}
}
