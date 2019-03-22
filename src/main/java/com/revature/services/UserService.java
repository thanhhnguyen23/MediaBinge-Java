package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.repos.UserRepo;

public class UserService {
	
	private UserRepo uRepo;
	
	@Autowired
	public UserService(UserRepo repo) {
		this.uRepo = repo;
	}
	
	@Transactional(readOnly = true)
	public List<User> getAll(){
		return uRepo.getAll();
	}
	
	@Transactional(readOnly = true)
	public User getById(int id) {
		return uRepo.getById(id);
	}
	
	@Transactional
	public User add(User newUser) {
		return uRepo.add(newUser);
	}
	
	@Transactional
	public User update(User updatedUser) {
		return uRepo.update(updatedUser);
	}
	
	@Transactional
	public boolean delete(int id) {
		return uRepo.delete(id);
	}
	
	

}
