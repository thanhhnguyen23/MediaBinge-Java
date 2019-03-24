package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Profile;
import com.revature.repos.ProfileRepo;


@Component
public class ProfileService {
	
	private ProfileRepo proRepo;
	
	@Autowired 
	public ProfileService(ProfileRepo profileRepo) {
		this.proRepo = profileRepo;
	}
	
	@Transactional(readOnly = true) 
	public List<Profile> getAll(){
		return proRepo.getAll();
	}
	
	@Transactional(readOnly = true)
	public Profile getById(int id) {
		return proRepo.getById(id);
	}
	
	@Transactional 
	public Profile add(Profile newProfile) {
		if(newProfile != null) {
			return proRepo.add(newProfile);
		}
		return null;
	}
	
	@Transactional 
	public Profile update(Profile updatedProfile) {
		if(updatedProfile != null) {
			return proRepo.update(updatedProfile);
		}
		return null; 
	}
	
	@Transactional 
	public boolean delete(int id) {
		return proRepo.delete(id);
	}

}
