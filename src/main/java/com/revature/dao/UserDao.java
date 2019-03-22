package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
<<<<<<< HEAD
=======
import org.hibernate.query.Query;
>>>>>>> Dao3-21

import com.revature.models.User;

public class UserDao implements DAO<User>{

	@Override
	public List getAll() {
<<<<<<< HEAD
		// TODO Auto-generated method stub
=======
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Query userQuery = session.getNamedQuery("getAllUsersHQL");
			List<User> users = userQuery.getResultList();
			return users;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
		
		return null;
	}
	
	public User getByUserId(int id) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Query userQuery = session.getNamedQuery("findUserByIdHQL");
//			List<User> users = userQuery.getResultList();
			userQuery.setParameter("user_id", id);
//			User users = userQuery.getSingleResult();
			List<User> users = userQuery.getResultList();
			return users.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
		
>>>>>>> Dao3-21
		return null;
	}

	@Override
	public User add(User user) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}
		return user;
	}


	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User update(User updatedObj) {
		// TODO Auto-generated method stub
		return null;
	}



}
