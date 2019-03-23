package com.revature.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.models.User;

@Component
public class UserRepo implements BasicRepo <User>{
	private SessionFactory factory;
	
	@Autowired
	public UserRepo(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}

	@Override
	public List<User> getAll() {
		Session session = factory.getCurrentSession();
		return session.createQuery("from User", User.class).getResultList();
	}

	@Override
	public User getById(int id) {
		Session session = factory.getCurrentSession();
		return session.get(User.class, id);
	}

	@Override
	public User add(User newUser) {
		Session session = factory.getCurrentSession();
		session.save(newUser);
		return newUser;
	}

	@Override
	public User update(User updatedUser) {
		Session session = factory.getCurrentSession();
		User user = session.get(User.class, updatedUser.getId());
		if(user == null) return null;
		else {
			user.setUsername(updatedUser.getUsername());
			user.setFirstName(updatedUser.getFirstName());
			user.setLastName(updatedUser.getLastName());
			user.setPassword(updatedUser.getPassword());
		}
		session.save(user);
		return user;
	}

	@Override
	public boolean delete(int id) {
		Session session = factory.getCurrentSession();
		User user = session.get(User.class, id);
		if (user == null) return false;
		session.delete(user);
		return true;
	}
}
