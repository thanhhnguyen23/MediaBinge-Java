package com.revature.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Response;

public class ResponseRepo implements BasicRepo<Response>{
	private SessionFactory factory;
	
	@Autowired
	public ResponseRepo (SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}

	@Override
	public List<Response> getAll() {
		Session session = factory.getCurrentSession();
		return session.createQuery("from Response", Response.class).getResultList();
	}

	@Override
	public Response getById(int id) {

		Session session = factory.getCurrentSession();
		return session.get(Response.class, id);

	}

	@Override
	public Response add(Response newResponse) {

		Session session = factory.getCurrentSession();
		session.save(newResponse);
		return newResponse;
		
	}

	@Override
	public Response update(Response updatedResponse) {
		Session session = factory.getCurrentSession();
		Response response = session.get(Response.class, updatedResponse.getResponseId());
		if(response == null) return null;
		else response = updatedResponse;
		return response;
	}

	@Override
	public boolean delete(int id) {

		Session session = factory.getCurrentSession();
		Response response = session.get(Response.class, id);
		if(response == null) return false;
		session.delete(response);
		return true;
	}

}
