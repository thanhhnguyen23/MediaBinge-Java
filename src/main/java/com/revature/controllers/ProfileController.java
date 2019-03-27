package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Post;
import com.revature.models.Principal;
import com.revature.models.Profile;
import com.revature.services.ProfileService;
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"content-type","Authorization"},exposedHeaders = {"Authorization","Info","UserFirstName","UserLastName","UserName"}, methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	private ProfileService service;
	
	@Autowired 
	public ProfileController(ProfileService profileService) {
		this.service = profileService;
	}
	
//	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Profile> getAll(){
		return service.getAll();
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Profile getByUserId(@RequestAttribute("principal") Principal principal) {
		System.out.println(principal);
		return service.getByUserId(Integer.parseInt(principal.getId()));
	}
	
	@GetMapping(value="/{id}")
	public Profile getProfileById(@PathVariable int id) {
		Profile profile = service.getById(id);
		return profile;	
	}
	/**
	 * currently not working
	 * wants a user object but won't read one when given
	 * attempted to create a constructor that took in a user id
	 * json still reads user as null and ignore userId
	 * @param newProfile
	 * @return
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Profile addProfile(@RequestBody Profile newProfile, @RequestAttribute("principal") Principal principal) {
		return service.add(newProfile,Integer.parseInt(principal.getId()));
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PatchMapping(consumes="application/json", produces=MediaType.APPLICATION_JSON_VALUE)
	public Profile updateProfile(@RequestBody Profile updatedProfile, @RequestAttribute("principal") Principal principal) {
		
		Profile profile = service.update(updatedProfile, Integer.parseInt(principal.getId()));
		return profile;
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProfile(@PathVariable int id) {
		service.delete(id);
	}
}
