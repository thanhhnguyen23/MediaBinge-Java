package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Post;
import com.revature.repos.PostRepo;

@Component
public class PostService {
	
	private PostRepo repo;
	
	@Autowired
	public PostService(PostRepo postRepo) {
		this.repo = postRepo;
	}
	
	@Transactional(readOnly = true)
	public List<Post> getAll(){
		return repo.getAll();
	}
	
	@Transactional(readOnly = true)
	public Post getById(int id) {
		return repo.getById(id);
	}
	
	@Transactional
	public Post add(Post newPost, int userId) {
		if(newPost != null && userId > 0) {
			return repo.add(newPost, userId);
		}
		return null;
		//TODO throw custom exception
	}
	
	@Transactional
	public Post update(Post updatedPost) {
		if(updatedPost != null){
			return repo.update(updatedPost);
		}
		return null;
		//TODO throw custom exception
	}
	
	@Transactional
	public boolean delete(int id) {
		return repo.delete(id);
	}

}
