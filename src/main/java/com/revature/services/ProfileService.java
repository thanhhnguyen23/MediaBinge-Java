package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Profile;
import com.revature.models.User;
import com.revature.repos.ProfileRepo;
import com.revature.repos.UserRepo;


@Component
public class ProfileService {
	
	private ProfileRepo proRepo;
	private UserRepo uRepo;
	
	@Autowired 
	public ProfileService(ProfileRepo profileRepo, UserRepo uRepo) {
		this.proRepo = profileRepo;
		this.uRepo = uRepo;
	}
	
	@Transactional(readOnly = true) 
	public List<Profile> getAll(){
		return proRepo.getAll();
	}
	
	@Transactional(readOnly = true)
	public Profile getByUserId(int id){
		return proRepo.getByUserId(id);
	}
	
	@Transactional(readOnly = true)
	public Profile getById(int id) {
		return proRepo.getById(id);
	}
	
	@Transactional 
	public Profile add(Profile newProfile, int id) {
		if(newProfile != null) {
			User user = uRepo.getById(id);
			newProfile.setUser(user);
			return proRepo.add(newProfile);
		}
		return null;
	}
	
	@Transactional 
	public Profile update(Profile updatedProfile, int id) {
		if(updatedProfile != null) {
			User user = uRepo.getById(id);
			updatedProfile.setUser(user);
			return proRepo.update(updatedProfile);
		}
		return null; 
	}
	
	@Transactional 
	public boolean delete(int id) {
		return proRepo.delete(id);
	}

}
