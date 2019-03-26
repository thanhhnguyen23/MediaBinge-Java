package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.repos.UserRepo;

@Component
public class UserService {
	
	private UserRepo uRepo;
	
	@Autowired
	public UserService(UserRepo userRepo) {
		this.uRepo = userRepo;
	}
	
	@Transactional(readOnly = true)
	public List<User> getAll(){
		return uRepo.getAll();
	}
	
	@Transactional(readOnly = true)
	public User getById(int id) {
		return uRepo.getById(id);
	}
	
	@Transactional(readOnly = true)
	public User getByCredentials(String username, String password)
	{
		return uRepo.getByCredentials(username, password);
	}
	
	@Transactional
	public User add(User newUser) {
		if(newUser != null) {
			return uRepo.add(newUser);
		}
		return null;
		//TODO throw custom exception
	}
	
	@Transactional
	public User update(User updatedUser) {
		if(updatedUser != null){
			return uRepo.update(updatedUser);
		}
		return null;
		//TODO throw custom exception
	}
	
	@Transactional
	public boolean delete(int id) {
		return uRepo.delete(id);
	}
	
	

}
