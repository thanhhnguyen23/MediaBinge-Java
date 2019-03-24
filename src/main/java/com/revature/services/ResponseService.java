package com.revature.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Response;
import com.revature.repos.ResponseRepo;

@Component
public class ResponseService {


		
		private ResponseRepo repo;
		
		@Autowired 
		public ResponseService(ResponseRepo responseRepo) {
			this.repo = responseRepo;
		}
		
		@Transactional(readOnly = true) 
		public List<Response> getAll(){
			return repo.getAll();
		}
		
		@Transactional(readOnly = true)
		public Response getById(int id) {
			return repo.getById(id);
		}
		
		@Transactional 
		public Response add(Response newRepo) {
			if(newRepo != null) {
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
