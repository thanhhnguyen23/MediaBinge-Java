package com.revature.repos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	@Override
	public Profile add(Profile newProfile) {
		Session session = factory.getCurrentSession();
		User user = session.get(User.class, newProfile.getUser().getId());
		if(user != null) {
			user.setProfile(newProfile);
			session.save(newProfile);
			return newProfile;
		}//TODO throw an exception here
		return null;
	}

	@Override
	public Profile update(Profile updatedProfile) {

		Session session = factory.getCurrentSession();
		Profile profile = session.get(Profile.class, updatedProfile.getProfileId());
		if(profile == null) return null;
		else profile = updatedProfile;
		return profile;
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
