package au.com.ac.bucketlist.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import au.com.ac.bucketlist.DAO.UserDao;
import au.com.ac.bucketlist.beans.Goal;
import au.com.ac.bucketlist.beans.User;

@Stateless
public class UserModel {
	
	@Inject
	private UserDao userDao;
	
	public User save(User userView){

		User userByEmail = findByEmail(userView.getEmail());

		if (userByEmail == null) {


			return userDao.persist(userView);
		}else{

			userByEmail.addGoal(userView.getGoals().iterator().next());
			
			update(userByEmail);
		}

		return userByEmail;
	}
	
	
	public void update(User u){
		userDao.update(u);
	}
	
	
	public User findByEmail(String email){
		return userDao.getBayEmail(email);
	}
	
	public List<Goal> findGoalsByEmail(String email){
		return userDao.getGoalsBayEmail(email);
	}



}
