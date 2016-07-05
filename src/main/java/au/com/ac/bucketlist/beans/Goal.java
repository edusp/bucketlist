package au.com.ac.bucketlist.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import au.com.ac.bucketlist.enums.Category;

@Entity
public class Goal {

	private long id;
	private String goalName;
	private Calendar dueDate;
	private Category category;
	private List<Comment> comments = new ArrayList<Comment>();

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "goal_name", length = 100)
	public String getGoalName() {
		return goalName;
	}

	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}


	@Column(name = "due_date")
	@Temporal(TemporalType.DATE)
	public Calendar getDueDate() {
		return dueDate;
	}

	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}

	@Enumerated(EnumType.STRING)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "comment_goal_user",
			joinColumns = @JoinColumn(name = "id_goal"),
			inverseJoinColumns = @JoinColumn(name = "id_comment")
			)
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> coments) {
		this.comments = coments;
	}

	@Override
	public String toString() {
		return "["+ "ID: " +id+", Email: "+ goalName+   "]";
	}

	

}
