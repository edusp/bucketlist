package au.com.ac.bucketlist.DAO;

import au.com.ac.bucketlist.beans.Goal;

public class GoalDao extends AbstractDAO<Goal>{


	public Goal getById(long id){
		return getEm().find(Goal.class, id);
	}
	
	
}
