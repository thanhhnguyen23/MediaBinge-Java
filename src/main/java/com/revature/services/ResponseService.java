package com.revature.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Post;
import com.revature.models.Response;
import com.revature.models.User;
import com.revature.repos.PostRepo;
import com.revature.repos.ResponseRepo;
import com.revature.repos.UserRepo;

@Component
public class ResponseService {


		private UserRepo uRepo;
		private ResponseRepo repo;
		private PostRepo pRepo;
		
		@Autowired 
		public ResponseService(ResponseRepo responseRepo, UserRepo uRepo, PostRepo pRepo) {
			this.repo = responseRepo;
			this.uRepo = uRepo;
			this.pRepo = pRepo;
		}
		
		@Transactional(readOnly = true) 
		public List<Response> getAll(){
			return repo.getAll();
		}
		@Transactional(readOnly = true)
		public List<Response> getByUserId(int id)
		{
			return repo.getByUserId(id);
		}
		@Transactional(readOnly = true)
		public List<Response> getByPostId(int id)
		{
			return repo.getByPostId(id);
		}
		
		@Transactional(readOnly = true)
		public Response getById(int id) {
			return repo.getById(id);
		}
		
		@Transactional 
		public Response add(Response newRepo, int userId,int postId) {
			if(newRepo != null) {
				System.out.println(userId + " " + postId);
				User user = uRepo.getById(userId);
				Post post = pRepo.getById(postId);
				post.addResponse(newRepo);
				newRepo.setPost(post);
				user.addResponse(newRepo);
				newRepo.setUser(user);
				
				return repo.add(newRepo);
			}
			return null;
		}
		
		@Transactional 
		public Response update(Response updatedReponse) {
			if(updatedReponse != null) {
				return repo.update(updatedReponse);
			}
			return null; 
		}
		
		@Transactional 
		public boolean delete(int id) {
			return repo.delete(id);
		}



}
