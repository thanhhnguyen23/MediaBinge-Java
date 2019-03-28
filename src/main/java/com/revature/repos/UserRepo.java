package com.revature.repos;


import java.util.List;







import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		User user = session.get(User.class, id);
		//Hibernate.initialize(user.getPosts()); //may or may not be necessary
		return user;
	}
	public User getByCredentials(String username, String password)
	{
		Session session = factory.getCurrentSession();
		Query myQuery = session.createQuery("from User u where u.username = :username AND u.password = :password");
		myQuery.setParameter("username", username);
		myQuery.setParameter("password", password);
		List<User> myUser = myQuery.getResultList();
		if(myUser.size() == 0)
		{
			return null;
		}
		return myUser.get(0);
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
			user.setlastName(updatedUser.getlastName());
			user.setPassword(updatedUser.getPassword());
			return user;
		}
		
		
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
