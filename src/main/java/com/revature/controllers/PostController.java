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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Post;
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
	
	@GetMapping(value="/{id}")
	public Post getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	//ADD
//	@ResponseStatus(HttpStatus.ACCEPTED)
//	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
//	public Post addPost(Post newPost) {
//		return service.add(newPost);
//	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping(value="/topic={topicId}/user={userId}",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Post addPost(@RequestBody Post newPost, @PathVariable int userId, @PathVariable int topicId) {
		return service.add(newPost, userId, topicId);
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
