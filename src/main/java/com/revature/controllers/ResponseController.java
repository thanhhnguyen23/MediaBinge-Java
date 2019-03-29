package com.revature.controllers;

import java.sql.Timestamp;
import java.util.List;

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
import com.revature.models.Response;
import com.revature.services.ResponseService;
@CrossOrigin(origins = "http://s3-jose-example.s3-website-us-east-1.amazonaws.com",
						allowedHeaders = {"content-type","Authorization"},
						exposedHeaders = {"Authorization","Info","UserFirstName","UserLastName","UserName"},
						methods = { RequestMethod.GET, RequestMethod.POST })
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
	@RequestMapping(value="/postId={id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Response> getByPostId(@PathVariable int id) {
		System.out.println(id);
		return service.getByPostId(id);
	}
	@RequestMapping(value="/userId={id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Response> getByUserId(@PathVariable int id) {
		System.out.println(id);
		return service.getByUserId(id);
	}
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Response getResponseById(@PathVariable int id) {
		return service.getById(id);
	}

	//ADD
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/{id}",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Response add(@RequestBody Response newResponse, @RequestAttribute("principal") Principal principal, @PathVariable int id) {
		System.out.println("hi");
		newResponse.setDatePosted(new Timestamp(System.currentTimeMillis()));
		return service.add(newResponse,Integer.parseInt(principal.getId()), id);
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
