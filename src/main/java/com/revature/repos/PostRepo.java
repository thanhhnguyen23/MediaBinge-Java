package com.revature.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.models.Post;
import com.revature.models.User;

@Component
public class PostRepo implements BasicRepo<Post>{
	private SessionFactory factory;

	@Autowired
	public PostRepo(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}

	@Override
	public List<Post> getAll() {
		Session session = factory.getCurrentSession();
		return session.createQuery("from Post", Post.class).getResultList();
	}

	@Override
	public Post getById(int id) {
		Session session = factory.getCurrentSession();
		return session.get(Post.class, id);
	}

	@Override
	public Post add(Post newPost) {
		Session session = factory.getCurrentSession();
		User user = session.get(User.class, newPost.getUser().getId());
		newPost.setUser(user);
		session.save(newPost);
		return newPost;
	}
	
	public Post add(Post newPost, int userId) {
		Session session = factory.getCurrentSession();
		User user = session.get(User.class, userId);
		newPost.setUser(user);
		session.save(newPost);
		return newPost;
	}

	@Override
	public Post update(Post updatedPost) {

		Session session = factory.getCurrentSession();
		Post post = session.get(Post.class, updatedPost.getPostId());
		if(post == null) return null;
		else post = updatedPost;
		return post;

	}

	@Override
	public boolean delete(int id) {
		Session session = factory.getCurrentSession();
		Post post = session.get(Post.class, id);
		if(post == null) return false;
		session.delete(post);
		return true;

	}

}
