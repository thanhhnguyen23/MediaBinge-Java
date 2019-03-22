package com.revature;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;

>>>>>>> Dao3-21
import com.revature.dao.UserDao;
import com.revature.models.User;

public class MediaBingeDriver {

	private static final UserDao userDao = new UserDao();

	public static void main(String[] args) {
<<<<<<< HEAD
		User user = new User(1, "test1", "firstName", "lastName", "p4ssword");

		System.out.println(user);
			
		userDao.add(user);
=======
//		User user = new User(1, "test3", "firstName", "lastName", "p4ssword");
//
//		System.out.println(user);
//			
//		userDao.add(user);
		
		List<User> allUsers = new ArrayList<>();
		
		allUsers = userDao.getAll();
		
		for(User u: allUsers)
		{
			System.out.println(u);
		}
		
		User user = userDao.getByUserId(1);
		System.out.println(user);
>>>>>>> Dao3-21
		
	}
}
