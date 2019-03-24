package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Profile;
import com.revature.services.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	private ProfileService service;
	
	@Autowired 
	public ProfileController(ProfileService profileService) {
		this.service = profileService;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Profile> getAll(){
		return service.getAll();
	}
	
	//@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Profile getProfileById(@PathVariable int id) {
		Profile profile = service.getById(id);
		return profile;	
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Profile addProfile(@RequestBody Profile newProfile) {
		return service.add(newProfile);
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PatchMapping(consumes="application/json", produces=MediaType.APPLICATION_JSON_VALUE)
	public Profile updateProfile(@RequestBody Profile updatedProfile) {
		Profile profile = service.update(updatedProfile);
		return profile;
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProfile(@PathVariable int id) {
		service.delete(id);
	}
}
