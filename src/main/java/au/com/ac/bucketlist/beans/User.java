package au.com.ac.bucketlist.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class User implements Serializable{

	private long id;
	private String email;
	private List<Goal> goals = new ArrayList<Goal>();

	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "user_goal",
			joinColumns = @JoinColumn(name = "id_user"),
			inverseJoinColumns = @JoinColumn(name = "id_goal")
			)	
	public List<Goal> getGoals() {
		return goals;
	}
	
	public List<Goal> goalsList() {
		return Collections.unmodifiableList(this.goals);
	}
	
	
	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

	@Transient
	public void addGoal(Goal goal){
		this.goals.add(goal);
	}
	
	
	@Override
	public String toString() {
		return "["+ "ID: " +id+", Email: "+ email+   "]";
	}

	
	
	
	

}
