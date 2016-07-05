package au.com.ac.bucketlist.api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import au.com.ac.bucketlist.beans.Goal;
import au.com.ac.bucketlist.beans.User;
import au.com.ac.bucketlist.model.GoalModel;
import au.com.ac.bucketlist.model.UserModel;

@Path("goal")
public class GoalRest {
	
	@Inject
	private UserModel uModel;
	
	@Inject
	private GoalModel gModel;
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Response saveGoal(User user){
		
		 User userSaved = uModel.save(user);
		 
		if (userSaved.getId() > 0){
			return Response.ok(userSaved).build();
		}
				
		return Response.serverError().build();
	}
	
	
	@POST
	@Path("/updatePost")
	@Produces({MediaType.APPLICATION_JSON})
	public Response addPost(Goal goal){
		
		return Response.ok(gModel.updatePost(goal)).build();
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response listGoals(@QueryParam("email") String email){
		return Response.ok(uModel.findByEmail(email)).build();
	}
	
	
	
	@GET
	@Path("/goalById")
	@Produces({MediaType.APPLICATION_JSON})
	public Response loadGoalById(@QueryParam("idGoal") long idGoal){
		return Response.ok(gModel.getGoalById(idGoal)).build();
	}
	
	
	

}
