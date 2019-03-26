package com.revature.controllers;

import java.util.List;

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

import com.revature.models.Response;
import com.revature.services.ResponseService;

@RestController
@RequestMapping("/response")
public class ResponseController {
	
	private ResponseService service;
	
	public ResponseController(ResponseService responseService) {
		this.service = responseService;
	}
	
	//READ
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Response> getAll(){
		return service.getAll();
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getResponseById(@PathVariable int id) {
		return service.getById(id);
	}
	
	//ADD
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Response add(@RequestBody Response newResponse) {
		return service.add(newResponse);
	}
	
	//UPDATE
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PatchMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Response updateResponse(@RequestBody Response updatedResponse) {
		return service.update(updatedResponse);
	}
	
	//DELETE
	@DeleteMapping(value="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteResponse(@PathVariable int id) {
		service.delete(id);
	}
	

}
