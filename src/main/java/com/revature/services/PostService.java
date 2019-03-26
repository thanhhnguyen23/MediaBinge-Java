package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repos.PostRepo;
import com.revature.repos.UserRepo;

@Component
public class PostService {
	
	private PostRepo repo;
	private UserRepo uRepo;
	
	
	@Autowired
	public PostService(PostRepo postRepo, UserRepo userRepo) {
		this.repo = postRepo;
		this.uRepo = userRepo;
	}
	
	@Transactional(readOnly = true)
	public List<Post> getAll(){
		return repo.getAll();
	}
	@Transactional(readOnly = true)
		public List<Post> getByUserId(int id)
		{
			return repo.getByUserId(id);
		}
	
	@Transactional(readOnly = true)
	public Post getById(int id) {
		return repo.getById(id);
	}
	
	@Transactional
	public Post add(Post newPost, int id) {
		if(newPost != null) {
			User user = uRepo.getById(id);
			
			System.out.println(user);
			newPost.setUser(user);
			user.addPost(newPost);
			return repo.add(newPost);
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
