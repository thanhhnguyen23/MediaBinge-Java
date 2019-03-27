package com.revature.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.models.Post;
import com.revature.models.Profile;
import com.revature.models.User;
@Component
public class ProfileRepo implements BasicRepo<Profile>{
	
	private SessionFactory factory;
	
	
	@Autowired
	public ProfileRepo(SessionFactory sessionFactory) {
		this.factory = sessionFactory;
	}

	@Override
	public List<Profile> getAll() {

		Session session = factory.getCurrentSession();
		return session.createQuery("from Profile", Profile.class).getResultList();
	}

	@Override
	public Profile getById(int id) {

		Session session = factory.getCurrentSession();
		return session.get(Profile.class, id);
	}
	
	public Profile getByUserId(int id)
	{
		Session session = factory.getCurrentSession();
		Query myQuery = session.createQuery("from Profile p where p.user.id = :userId");
		myQuery.setParameter("userId", id);
		List<Profile> profiles = myQuery.getResultList();
		return profiles.get(0);
	}
		

	@Override
	public Profile add(Profile newProfile) {
	Session session = factory.getCurrentSession();
		System.out.println(newProfile);

		if(newProfile!= null) {
			session.save(newProfile);
			return newProfile;
		}//TODO throw an exception here
		return null;
	}

	@Override
	public Profile update(Profile updatedProfile) {

		Session session = factory.getCurrentSession();
		Profile profile = session.get(Profile.class, updatedProfile.getProfileId());
		System.out.println(profile);
		if(profile == null) { return null;}
		else { 
		profile.setFavoriteBooks(updatedProfile.getFavoriteBooks());
		profile.setFavoriteMovies(updatedProfile.getFavoriteMovies());
		profile.setFavoriteTvShows(updatedProfile.getFavoriteTvShows());
		return profile;
		}
	}

	@Override
	public boolean delete(int id) {
		Session session = factory.getCurrentSession();
		Profile profile = session.get(Profile.class, id);
		if(profile == null) return false;
		session.delete(profile);
		return true;
	}

}
