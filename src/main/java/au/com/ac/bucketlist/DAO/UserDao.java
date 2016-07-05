package au.com.ac.bucketlist.DAO;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import au.com.ac.bucketlist.beans.Goal;
import au.com.ac.bucketlist.beans.User;


public class UserDao extends AbstractDAO<User>{

	public User getBayEmail(String email) {

		Query query = getEm().createQuery("from User where email = :email")
				.setParameter("email", email);

		try {

			return (User) query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}

	}
	
	
	public List<Goal> getGoalsBayEmail(String email) {

		Query query = getEm().createQuery("from User where email = :email")
				.setParameter("email", email);

		try {

			return ( (User) query.getSingleResult()).goalsList();

		} catch (NoResultException e) {
			return null;
		}

	}



}
