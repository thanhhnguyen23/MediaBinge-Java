package com.revature.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Post;
import com.revature.models.Principal;
import com.revature.services.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	
	private PostService service;
	
	@Autowired
	public PostController(PostService postService) {
		this.service = postService;
	}
	
	//READ
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Post> getAll(){
		return service.getAll();
	}
	
	@RequestMapping(value="/topic={id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Post> getByTopicId(@PathVariable int id) {
		System.out.println(id);
		return service.getByTopicId(id);
	}
	

	@RequestMapping(value="/user={id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Post> getByUserId(@PathVariable int id) {
		System.out.println(id);
		return service.getByUserId(id);
	}
	//GET BY POST ID
	@GetMapping(value="/{id}")
	public Post getById(@PathVariable int id) {
		return service.getById(id);
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Post addPost(@RequestBody Post newPost, @RequestAttribute("principal") Principal principal) {
		newPost.setDatePosted(new Timestamp(System.currentTimeMillis()));
		return service.add(newPost, Integer.parseInt(principal.getId()));
	}
		
	//UPDATE
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PatchMapping(consumes="application/json", produces="application/json")
	public Post editPost(@RequestBody Post updatedPost) {
		return service.update(updatedPost);
	}
	
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePost(@PathVariable int id) {
		service.delete(id);
	}
	

}
