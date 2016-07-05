package au.com.ac.bucketlist.model;

import javax.ejb.Stateless;
import javax.inject.Inject;

import au.com.ac.bucketlist.DAO.GoalDao;
import au.com.ac.bucketlist.beans.Goal;

@Stateless
public class GoalModel {
	
	@Inject
	private GoalDao goalDao;
	

	public Goal getGoalById(long idGoal) {
		return goalDao.getById(idGoal);
	}


	public Goal updatePost(Goal goal) {
		return goalDao.update(goal);
	}

	

}
